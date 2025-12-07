package com.ttknp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "com.ttknp")
@SpringBootApplication
public class ApiUsingSpringBootApplyCustomService3CrudMysqlV2Application {

    public static void main(String[] args) {
        SpringApplication.run(ApiUsingSpringBootApplyCustomService3CrudMysqlV2Application.class, args);
    }

}
