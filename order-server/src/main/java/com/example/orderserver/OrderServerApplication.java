package com.example.orderserver;

import mybatis.MybatisPlusCodeGenerator;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;

@MapperScan("com.example.orderserver.mapper")
@SpringBootApplication
@EnableEurekaClient
public class OrderServerApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(OrderServerApplication.class, args);
        MybatisPlusCodeGenerator mybatisPlusCodeGenerator = (MybatisPlusCodeGenerator)context.getBean("mybatisPlusCodeGenerator");
        mybatisPlusCodeGenerator.codeGenerator();

    }

}
