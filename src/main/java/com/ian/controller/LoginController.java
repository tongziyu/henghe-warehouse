package com.ian.controller;

import com.google.code.kaptcha.Producer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
