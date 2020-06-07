package com.linht.framework.ioc.bean;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class BeanDefinition {

    private Object bean;

    private Class beanClass;

    private String beanClassName;

    private List<PropertyValue> propertyValues = Lists.newArrayList();

    public void setBeanClassName(String beanClassName) {
        this.beanClassName = beanClassName;
        try {
            this.beanClass = Class.forName(beanClassName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

}
