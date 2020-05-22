package com.atguigu.test0522;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication
@MapperScan(basePackages = "com.atguigu.test0522.mapper")
public class Test0522Application {

    public static void main(String[] args) {
        SpringApplication.run(Test0522Application.class, args);
    }

}
