package com.ian.config;

import com.ian.filter.LoginCheckFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * @Description: Servlet 配置文件
 * @Author: Ian
 * @Date: 2023/9/15 19:08
 */
@Configuration
public class ServletConfig {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    /**
     * 配置过滤器
     * @return
     */
    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean<>();
        // 将自己的过滤器添加进bean中
        LoginCheckFilter loginCheckFilter = new LoginCheckFilter();
        loginCheckFilter.setRedisTemplate(stringRedisTemplate);
        filterRegistrationBean.setFilter(loginCheckFilter);

        // 设置拦截请求
        filterRegistrationBean.addUrlPatterns("/*");

        return filterRegistrationBean;
    }
}
