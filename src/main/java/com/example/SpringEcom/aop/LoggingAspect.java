package com.example.SpringEcom.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

@Component
@Aspect
public class LoggingAspect {

    private final Logger logger = Logger.getLogger(LoggingAspect.class
            .getName());
    private FileHandler fh = null;

    public void configLogger() {
        //just to make our log file nicer :)
        SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
        try {
            fh = new FileHandler("C:\\Users\\idoke\\IdeaProjects\\SpringEcom\\src\\main\\resources\\logs\\"
                    + format.format(Calendar.getInstance().getTime()) + ".log");
        } catch (Exception e) {
            e.printStackTrace();
        }

        fh.setFormatter(new SimpleFormatter());
        logger.addHandler(fh);
    }

    @Before("execution(* com.example.SpringEcom.service.ProductService.*(..))")
    public void logMethodCall(JoinPoint jp) {
        logger.info(jp.getSignature().getName() + " Called");
    }
}
