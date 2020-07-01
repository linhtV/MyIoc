package com.linht.framework.ioc.aop;


public interface PointcutAdvisor extends Advisor{

    Pointcut getPointcut();

}
