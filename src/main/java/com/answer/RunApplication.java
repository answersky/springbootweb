package com.answer;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * created by liufeng
 * 2018/8/21
 */
@Configuration
@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.answer")
@MapperScan("com.answer.dao")
public class RunApplication {


    public static void main(String[] args) {
        SpringApplication.run(RunApplication.class,args);
    }
}
