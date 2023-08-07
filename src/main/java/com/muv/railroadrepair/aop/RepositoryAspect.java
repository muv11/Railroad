package com.muv.railroadrepair.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class RepositoryAspect {

    private final Logger LOGGER = LoggerFactory.getLogger(this.getClass());

    @Pointcut("execution(* com.muv.railroadrepair.repository.*.find*())")
    private void findNoArgsPointcut() {}
    @Pointcut("execution(* com.muv.railroadrepair.repository.*.find*(..))")
    private void findWithArgsPointcut() {}

    @Before("findNoArgsPointcut()")
    private void enterFindMethods() {
        LOGGER.info("ENTERING find METHOD");
    }

    @Before("findWithArgsPointcut() && args(name)")
    private void enterFindMethods(String name) {
        LOGGER.info("ENTERING find METHOD WITH FOLLOWING DATA " + name);
    }

    @After("findNoArgsPointcut() || findWithArgsPointcut()")
    private void leaveFindMethods() {
        LOGGER.info("LEAVING find METHOD");
    }

}
