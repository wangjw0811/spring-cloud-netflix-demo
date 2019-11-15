package com.example.userserver;

import mybatis.MybatisPlusCodeGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableEurekaClient
@MapperScan("com.example.userserver.mapper")
public class UserServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(UserServerApplication.class, args);
        MybatisPlusCodeGenerator generator = (MybatisPlusCodeGenerator) context.getBean("mybatisPlusCodeGenerator");
        generator.codeGenerator();
    }

}
