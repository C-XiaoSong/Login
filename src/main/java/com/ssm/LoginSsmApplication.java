package com.ssm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("com.ssm.mapper") //扫描Mapper层
public class LoginSsmApplication implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(LoginSsmApplication.class, args);
    }
}