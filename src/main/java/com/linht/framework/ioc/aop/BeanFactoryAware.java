package com.linht.framework.ioc.aop;

import com.linht.framework.ioc.core.BeanFactory;

public interface BeanFactoryAware {
    void setBeanFactory(BeanFactory beanFactory) throws Exception;
}
