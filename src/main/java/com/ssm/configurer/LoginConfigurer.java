package com.ssm.configurer;

import com.ssm.interceptor.FilterInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

@Configuration
public class LoginConfigurer implements WebMvcConfigurer {
    /**
     * list里面的是需要放行的页面
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        HandlerInterceptor interceptor = new FilterInterceptor();
        List list = new ArrayList();
        list.add("/login");
        list.add("/login.html");
        list.add("/register");
        list.add("/register.html");
        list.add("/insert");
        list.add("/insert.html");
        list.add("/css/**");
        list.add("/css/**");
        list.add("/img/**");
        list.add("/js/**");
        list.add("/plugins/**");
        registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(list);
    }
}
