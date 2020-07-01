package com.linht.framework.ioc.aop;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 被代理的对象
 */
public class TargetSource {

    private Class<?>[] targetClass;

    private Object target;

    public TargetSource(Object target, Class<?>... targetClass) {
        this.target = target;
        this.targetClass = targetClass;
    }

    public Class<?>[] getTargetClass() {
        return targetClass;
    }

    public Object getTarget() {
        return target;
    }


}
