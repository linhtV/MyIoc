package com.linht.framework.ioc.aop;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 被代理的对象
 */
@AllArgsConstructor
public class TargetSource {

    @Getter
    private Object target;

    @Getter
    private Class targetClass;


}
