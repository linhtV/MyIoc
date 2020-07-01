package com.linht.framework.ioc.aop;

import com.linht.framework.ioc.entity.Body;
import com.linht.framework.ioc.entity.Robot;
import org.junit.Assert;
import org.junit.Test;

public class AspectJExpressionPointcutTest {

    @Test
    public void testClassFilter() throws Exception {
        String expression = "execution(* com.linht.framework.ioc.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getClassFilter().matches(Body.class);
        Assert.assertTrue(matches);
    }

    @Test
    public void testMethodInterceptor() throws Exception {
        String expression = "execution(* com.linht.framework.ioc.entity.*.*(..))";
        AspectJExpressionPointcut aspectJExpressionPointcut = new AspectJExpressionPointcut();
        aspectJExpressionPointcut.setExpression(expression);
        boolean matches = aspectJExpressionPointcut.getMethodMatcher().matches(Robot.class.getDeclaredMethod("show"),Robot.class);
        Assert.assertTrue(matches);
    }
}
