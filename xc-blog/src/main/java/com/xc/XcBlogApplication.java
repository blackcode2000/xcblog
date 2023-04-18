package com.xc;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xc.mapper")
public class XcBlogApplication {
    public static void main(String[] args) {
        SpringApplication.run(XcBlogApplication.class,args);
    }
}
