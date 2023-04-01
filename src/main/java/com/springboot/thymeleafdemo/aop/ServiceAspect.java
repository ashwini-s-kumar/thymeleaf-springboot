package com.springboot.thymeleafdemo.aop;

import com.springboot.thymeleafdemo.controller.CourseController;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Aspect
@Component
public class ServiceAspect {

    @Autowired
    private CourseController courseController;
    private static final Logger log = Logger.getLogger(ServiceAspect.class.getName());

    @Around("execution(* com.springboot.thymeleafdemo.service.CourseServiceImpl.findAll(..))")
    public Object aroundGetEmployeeList(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        log.info("============> Executing @Around on method CourseServiceImpl.findAll()");
        long begin = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        long end = System.currentTimeMillis();

        log.info(" ===========> Duration taken to fetch all courses by Service Layer = "+ (end - begin) /1000 +" sec");
        return result;
    }

    @Around("execution(* com.springboot.thymeleafdemo.service.CourseServiceImpl.findById(..))")
    public Object aroundGetCourseById(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{

        Object result;
        log.info("============> Executing @Around on method CourseServiceImpl.findById()");
        long begin = System.currentTimeMillis();
        try {
             result = proceedingJoinPoint.proceed();
        }catch (Exception e){
            log.severe("Exception while getting Course by ID in service layer : " + e);
            result = null;
        }
        long end = System.currentTimeMillis();

        log.info(" ===========> Duration taken to fetch course by Service Layer = "+ (end - begin) /1000 +" sec");
        return result;
    }
}
