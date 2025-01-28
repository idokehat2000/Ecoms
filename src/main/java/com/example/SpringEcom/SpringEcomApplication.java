package com.example.SpringEcom;

import com.example.SpringEcom.aop.LoggingAspect;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringEcomApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(SpringEcomApplication.class, args);
        LoggingAspect log = ctx.getBean(LoggingAspect.class);
        log.configLogger();
    }

}
