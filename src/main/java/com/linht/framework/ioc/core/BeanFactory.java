package com.linht.framework.ioc.core;

import com.linht.framework.ioc.bean.BeanDefinition;

public interface BeanFactory {

    /**
     * 根据名称获取bean
     * @param name
     * @return
     * @throws Exception
     */
    Object getBean(String name);

    /**
     * 注册bean
     * @param name
     * @param beanDefinition
     */
    void registerBeanDefinition(String name, BeanDefinition beanDefinition) throws Exception;
}
