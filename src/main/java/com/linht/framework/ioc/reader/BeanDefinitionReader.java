package com.linht.framework.ioc.reader;

public interface BeanDefinitionReader {

    void loadBeanDefinitions(String location) throws Exception;

}
