package com.linht.framework.ioc.aop;

import com.linht.framework.ioc.context.ApplicationContext;
import com.linht.framework.ioc.context.ClassPathXmlApplicationContext;
import com.linht.framework.ioc.entity.Body;
import org.junit.Test;

public class JdkDynamicAopProxyTest {

    @Test
    public void testInterceptor() throws Exception {
        // --------- helloWorldService without AOP
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myioc.xml");
        Body body = (Body) applicationContext.getBean("robot");
        body.show();

        // --------- helloWorldService with AOP
        // 1. 设置被代理对象(Joinpoint)
        AdvisedSupport advisedSupport = new AdvisedSupport();
        TargetSource targetSource = new TargetSource(body, Body.class);
        advisedSupport.setTargetSource(targetSource);

        // 2. 设置拦截器(Advice)
        TimerInterceptor timerInterceptor = new TimerInterceptor();
        advisedSupport.setMethodInterceptor(timerInterceptor);

        // 3. 创建代理(Proxy)
        JdkDynamicAopProxy jdkDynamicAopProxy = new JdkDynamicAopProxy(advisedSupport);
        Body bodyProxy = (Body) jdkDynamicAopProxy.getProxy();

        // 4. 基于AOP的调用
        body.show();

    }

}