package com.cydeo.aspect;

import com.cydeo.dto.CourseDTO;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Aspect
@Component
public class LoggingAspect {

    Logger logger = LoggerFactory.getLogger(LoggingAspect.class);//interface//old structure -  providing information on console

//
//    @Pointcut("execution(* com.cydeo.controller.CourseController.*(..))")//defining my join points
//    public void myPointcut() {
//    }

//    @Before("myPointcut()")  //@before advice execute before any methode
//    public void log() {//Log some information on console
//        logger.info("Info log ..........");
//    }

//    //Advice
//    @Before("execution(* com.cydeo.controller.CourseController.*(..))")
//    public void log() {
//        logger.info("Info log ..........");
//
//    }
//
//    @Pointcut("execution(* com.cydeo.repository.CourseRepository.findById(*))")//for one parameter
//    public void courseRepositoryFindByIdPC(){}//empty method
//    //Advice
//    @Before("courseRepositoryFindByIdPC()")
//        public void beforeCourseRepositoryFindById(JoinPoint joinPoint){
//        logger.info("Before -> Method: {} , Arguments: {}, Target: {}"  //curly braces are working with logger method() and {} braces will be replaced with joinPoint()
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget()); //join point  that we want see
//

//    }
//    @Pointcut("within(com.cydeo.controller..*)")
//    public void anyControllerOperation(){}
//    @Pointcut("@within(org.springframework.stereotype.Service)")//get @Service (@within) from service
//    public void anyServiceOperation() {}
//        @Before("anyControllerOperation() || anyServiceOperation()")
//        public void beforeControllerOrService (JoinPoint joinPoint){
//            logger.info("Before -> Method: {} , Arguments: {}, Target: {}"
//                    , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//
//    }
//
//    @Pointcut("@annotation(org.springframework.web.bind.annotation.DeleteMapping)")
//    public void anyDeleteControllerOperation() {
//    }
//
//    @Before("anyDeleteControllerOperation()")
//    public void beforeDeleteMappingAnnotation(JoinPoint joinPoint) {
//        logger.info("Before -> Method: {} , Arguments: {}, Target: {}"
//                , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//
//
//    }
//
//    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")
//    public void loggingAnnotationPC(){}
//    @Before("loggingAnnotationPC()")
//    public void beforeLoggingAnnotation(JoinPoint joinPoint){
//        logger.info("Before -> Method: {}, Arguments: {} , Target: {}"
//        , joinPoint.getSignature(), joinPoint.getArgs(), joinPoint.getTarget());
//    }


//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void afterReturningGetMappingAnnotation(){}

//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "result")
//    public void afterReturningGetMappingAnnotation(JoinPoint joinPoint, Object result){
//        logger.info("After Returning -> Methode: {}, Result: {}", joinPoint.getSignature(), result.toString());
//    }


//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void afterReturningGetMappingAnnotation(){}
//
//    @AfterReturning(pointcut = "afterReturningGetMappingAnnotation()", returning = "results")
//    public void afterReturningGetMappingAnnotation(JoinPoint joinPoint, List<CourseDTO> results){
//        logger.info("After Returning -> Methode: {}, Result: {}", joinPoint.getSignature(), results.toString());
//    }

    //CourseDTO->Object --> this is OK
    //List<CourseDTO> -> List<Object> --> this is not OK

//    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
//    public void afterReturningGetMappingAnnotation(){}

//    @AfterThrowing(pointcut = "afterReturningGetMappingAnnotation()", throwing = "exception")
//    public void afterThrowingGetMappingOperation(JoinPoint joinPoint,RuntimeException exception){
//        logger.error("After Throwing  -> Method: {}, Exception: {}"
//        , joinPoint.getSignature().toShortString(), exception.getMessage());
//    }


    @Pointcut("@annotation(com.cydeo.annotation.LoggingAnnotation)")//costume annotation
    public void loggingAnnotationPC(){}

    @Around ("loggingAnnotationPC()")//point cut name
    public Object anyLoggingAnnotationOperation(ProceedingJoinPoint proceedingJoinPoint){//first parameter before
        logger.info("Before -> Method: {} - Parameter {}"
        , proceedingJoinPoint.getSignature().toShortString(), proceedingJoinPoint.getArgs());

        Object result = null;
        try{
            result = proceedingJoinPoint.proceed(); //this is method
;        }catch (Throwable throwable){
            throwable.printStackTrace();
        }

        logger.info("After - Method: {} - Result: {}"
        , proceedingJoinPoint.getSignature().toShortString(), result.toString());//after
        return result;


    }
























}