package com.ian.filter;

import com.alibaba.fastjson.JSON;
import com.ian.pojo.Result;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * @Description:
 * @Author: Ian
 * @Date: 2023/9/15 19:14
 */
public class LoginCheckFilter implements Filter {

    private StringRedisTemplate redisTemplate;

    public void setRedisTemplate(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;

        // 将白名单的请求 放行
        String servletPath = request.getServletPath();

        List<String> urlList = new ArrayList<>();

        urlList.add("/login");
        urlList.add("/captcha/captchaImage");
        urlList.add("/logout");
        urlList.add("/product/img-upload");
        if (urlList.contains(servletPath) || servletPath.contains("/img/upload")){
            filterChain.doFilter(request,response);
            return;
        }
        // 其余的请求都校验token
        // 判断请求头中携带了 token了吗
        String token = request.getHeader("token");

        if (StringUtils.hasText(token) && redisTemplate.hasKey(token)){
            filterChain.doFilter(request,response);
            return;
        }
        Result result = Result.err(Result.CODE_ERR_UNLOGINED, "请登录");
        String jsonString = JSON.toJSONString(result);

        response.setContentType("application/json;charset=utf-8");

        PrintWriter writer = response.getWriter();
        writer.write(jsonString);
        writer.flush();
        writer.close();


    }
}
