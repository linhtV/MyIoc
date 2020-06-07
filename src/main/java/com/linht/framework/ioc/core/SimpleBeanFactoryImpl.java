package com.linht.framework.ioc.core;

import com.linht.framework.ioc.bean.BeanDefinition;
import com.linht.framework.ioc.bean.PropertyValue;

import java.lang.reflect.Field;

public class SimpleBeanFactoryImpl extends AbstractBeanFactory {

    @Override
    protected Object doCreateBean(BeanDefinition beanDefinition) throws Exception {
        Object bean = createBeanInstance(beanDefinition);
        applyPropertyValues(bean, beanDefinition);
        return bean;

    }

    protected Object createBeanInstance(BeanDefinition beanDefinition) throws Exception {
        return beanDefinition.getBeanClass().newInstance();
    }

    protected void applyPropertyValues(Object bean, BeanDefinition bd) throws Exception {
        for (PropertyValue propertyValue : bd.getPropertyValues()) {
            Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
            declaredField.setAccessible(true);
            declaredField.set(bean, propertyValue.getValue());
        }
    }
}
