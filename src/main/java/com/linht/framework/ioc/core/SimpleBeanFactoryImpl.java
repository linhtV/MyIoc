package com.linht.framework.ioc.core;

import com.linht.framework.ioc.aop.BeanFactoryAware;
import com.linht.framework.ioc.bean.BeanDefinition;
import com.linht.framework.ioc.bean.BeanReference;
import com.linht.framework.ioc.bean.PropertyValue;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class SimpleBeanFactoryImpl extends AbstractBeanFactory {

    protected void applyPropertyValues(Object bean, BeanDefinition bd) throws Exception {
        if (bean instanceof BeanFactoryAware) {
            ((BeanFactoryAware) bean).setBeanFactory(this);
        }
        for (PropertyValue propertyValue : bd.getPropertyValues()) {
            Object value = propertyValue.getValue();
            if (value instanceof BeanReference) {
                BeanReference beanReference = (BeanReference) value;
                value = getBean(beanReference.getName());
            }

            try {
                Method declaredMethod = bean.getClass().getDeclaredMethod(
                        "set" + propertyValue.getName().substring(0, 1).toUpperCase()
                                + propertyValue.getName().substring(1), value.getClass());
                declaredMethod.setAccessible(true);

                declaredMethod.invoke(bean, value);
            } catch (NoSuchMethodException e) {
                Field declaredField = bean.getClass().getDeclaredField(propertyValue.getName());
                declaredField.setAccessible(true);
                declaredField.set(bean, value);
            }
        }
    }
}
