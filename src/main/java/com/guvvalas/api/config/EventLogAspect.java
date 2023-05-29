package com.guvvalas.api.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

@Slf4j
@Aspect
@Component
public class EventLogAspect {

    @Around(value = "@within(com.guvvalas.api.config.EventLog) || @annotation(com.guvvalas.api.config.EventLog)")
    public Object getObject(ProceedingJoinPoint joinPoint)throws Throwable{

        MethodSignature signature=(MethodSignature) joinPoint.getSignature();
        Method method=signature.getMethod();

        var result = joinPoint.proceed();

        return null;



    }


    }
