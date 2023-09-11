package com.zgbest.zgBlogFront;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.zgbest.zgBlogFront.mapper")
public class ZgBlogFrontApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZgBlogFrontApplication.class, args);
    }

}
