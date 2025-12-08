package com.ttknp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication(scanBasePackages = "com.ttknp")// it's same @ComponentScan(basePackages = {"com.ttknp"}) // *** if you gonna test (with mockito) you have to comment this annotation
public class ApiUsingSpringBootApplyCustomService3CrudMysqlV2Application {

    public static void main(String[] args) {
        SpringApplication.run(ApiUsingSpringBootApplyCustomService3CrudMysqlV2Application.class, args);
    }

}
