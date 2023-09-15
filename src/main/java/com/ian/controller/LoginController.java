package com.ian.controller;

import com.google.code.kaptcha.Producer;
import com.ian.pojo.Result;
import com.ian.pojo.dto.LoginUserDTO;
import com.ian.pojo.entity.User;
import com.ian.service.UserService;
import com.ian.utils.CurrentUser;
import com.ian.utils.DigestUtil;
import com.ian.utils.TokenUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Delete;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/15 16:13
 */
@RestController
@Slf4j
public class LoginController {
    @Autowired
    private Producer producer;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @Autowired
    private TokenUtils tokenUtils;


    /**
     * 生成验证码
     * @param response
     */
    @RequestMapping("/captcha/captchaImage")
    public void captchaImage(HttpServletResponse response)  {

        // 生成验证码图片的文本
        String text = producer.createText();

        // 使用验证码文本生成验证码图片
        BufferedImage image = producer.createImage(text);

        // 保存验证码文本作为key保存进redis,验证的时候,直接向redis里面查询,如果查到了就是对了
        // 设置键的过期时间
        redisTemplate.opsForValue().set(text,"",60*30, TimeUnit.SECONDS);

        // 设置响应头的格式
        response.setContentType("image/jpeg");
        ServletOutputStream outputStream = null;
        // 将验证码响应给前端
        try {
            outputStream = response.getOutputStream();

            ImageIO.write(image,"jpg",outputStream);

            // 刷新
            outputStream.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }finally {
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    /**
     * 用户登录
     * @param loginUserDTO
     * @return
     */
    @PostMapping("/login")
    public Result login(@RequestBody LoginUserDTO loginUserDTO){
        // 判断验证码是否和redis中的一致
        String verificationCode = loginUserDTO.getVerificationCode();
        if (verificationCode != null){
            // 判断redis中有没有这个key,如果没有 则返回验证码错误
            if(!redisTemplate.hasKey(verificationCode)){
                return Result.err(Result.CODE_ERR_BUSINESS,"验证码错误!");
            }

        }

        /*
            查询数据库
                1. 根据账号查询数据库, 查到了 判断密码是否正确, 查不到 返回错误信息 账号不存在
                2. 查询数据库的时候 判断 is_delete字段 为0
                3. select * from user_info where user_code = #{userCode} and is_delete = 0;
                4. 账号密码都对的情况下,生成token,返回给前端
         */
        User user = userService.selectByUserCode(loginUserDTO.getUserCode());

        // 如果查到了 直接就核对密码
        if (user != null){
            // 核对密码
            String verifyPwd = DigestUtil.hmacSign(loginUserDTO.getUserPwd());

            if (verifyPwd.equals(user.getUserPwd())){
                // 生成token 存储进redis
                CurrentUser currentUser = new CurrentUser();
                currentUser.setUserId(user.getUserId());
                currentUser.setUserCode(user.getUserCode());
                currentUser.setUserName(user.getUserName());

                String token = tokenUtils.loginSign(currentUser, user.getUserPwd());
                // 向客户端响应 token
                return Result.ok("登陆成功",token);
            }else{
                // 如果密码不对 就返回密码不对信息
                return Result.err(Result.CODE_ERR_BUSINESS,"密码错误!");
            }

        }else{
            // 如果根据账号没查到,就返回账号不存在 错误信息
            return Result.err(Result.CODE_ERR_BUSINESS,"账号不存在!");
        }
    }

    /**
     * 获取当前用户
     * @param token
     * @return
     */
    @GetMapping("/curr-user")
    public Result getCurrentUser(@RequestHeader("token") String token){
        CurrentUser currentUser = tokenUtils.getCurrentUser(token);
        return Result.ok(currentUser);
    }

    /**
     * 用户退出登录
     * @return
     */
    @DeleteMapping("/logout")
    public Result logout(@RequestHeader("token") String token){
        redisTemplate.delete(token);
        return Result.ok();
    }
}
