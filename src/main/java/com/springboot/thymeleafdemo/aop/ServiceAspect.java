package com.springboot.thymeleafdemo.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ServiceAspect {
    private static final Logger log = Logger.getLogger(ServiceAspect.class.getName());

    @Around("execution(* com.springboot.thymeleafdemo.service.EmployeeServiceImpl.findAll(..))")
    public Object aroundGetEmployeeList(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        log.info("============> Executing @Around on method EmployeeServiceImpl.findAll()");
        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        log.info(" ===========> Duration taken to fetch all employees by Service Layer = "+ (end - begin) /1000 +" sec");
        return result;
    }

    @Around("execution(* com.springboot.thymeleafdemo.service.EmployeeServiceImpl.findById(..))")
    public Object aroundGetEmployeeById(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        Object result;
        log.info("============> Executing @Around on method EmployeeServiceImpl.findById()");
        long begin = System.currentTimeMillis();
        try {
             result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            log.severe("Exception while getting employee by ID in service layer : " + e);
            result = "Interval Server Error.";
        }
        long end = System.currentTimeMillis();

        log.info(" ===========> Duration taken to fetch all employees by Service Layer = "+ (end - begin) /1000 +" sec");
        return result;
    }
}
