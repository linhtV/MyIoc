package com.linht.framework.ioc.aop;

import lombok.Getter;
import lombok.Setter;
import org.aopalliance.intercept.MethodInterceptor;

/**
 * 代理相关的元数据
 */
@Setter
@Getter
public class AdvisedSupport {

    private TargetSource targetSource;

    private MethodInterceptor methodInterceptor;

    private MethodMatcher methodMatcher;


}
