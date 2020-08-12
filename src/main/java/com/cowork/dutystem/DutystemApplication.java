package com.cowork.dutystem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class DutystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(DutystemApplication.class, args);
    }

}
