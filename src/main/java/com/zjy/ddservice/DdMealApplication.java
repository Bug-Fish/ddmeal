package com.zjy.ddservice;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.zjy"})
@MapperScan("com.zjy.ddservice.mapper")
public class DdMealApplication {
    public static void main(String[] args) {
        SpringApplication.run(DdMealApplication.class, args);
    }
}
