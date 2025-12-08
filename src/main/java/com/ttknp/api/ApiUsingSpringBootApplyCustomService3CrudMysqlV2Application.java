package com.ttknp.api;

import com.ttknp.jdbccustomservice.jdbc.utility.JdbcReadSQLFileHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Service;


@SpringBootApplication(scanBasePackages = "com.ttknp")// it's same @ComponentScan(basePackages = {"com.ttknp"}) // *** if you gonna test (with mockito) you have to comment this annotation
@Service
public class ApiUsingSpringBootApplyCustomService3CrudMysqlV2Application {

    private final JdbcReadSQLFileHelper jdbcReadSQLFileHelper;

    @Autowired
    private ApiUsingSpringBootApplyCustomService3CrudMysqlV2Application(JdbcReadSQLFileHelper jdbcReadSQLFileHelper) {
        this.jdbcReadSQLFileHelper = jdbcReadSQLFileHelper;
        this.jdbcReadSQLFileHelper.loadScriptRootPath("sql/init_db.sql");
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiUsingSpringBootApplyCustomService3CrudMysqlV2Application.class, args);
    }

}
