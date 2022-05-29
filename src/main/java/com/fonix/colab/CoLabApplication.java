package com.fonix.colab;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication
@ServletComponentScan
@EnableConfigurationProperties
@MapperScan("com.fonix.colab.mapper")
public class CoLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(CoLabApplication.class, args);
    }

}
