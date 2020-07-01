package com.linht.framework.ioc.aop;

import com.linht.framework.ioc.core.BeanFactory;
import lombok.Getter;
import lombok.Setter;
import org.aopalliance.aop.Advice;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

import java.lang.reflect.Method;

@Getter
@Setter
public class AspectJAroundAdvice implements Advice, MethodInterceptor {

    private BeanFactory beanFactory;

    private Method aspectJAdviceMethod;

    private String aspectInstanceName;

    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        return aspectJAdviceMethod.invoke(beanFactory.getBean(aspectInstanceName), invocation);
    }
}
