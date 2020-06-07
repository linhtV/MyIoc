package com.linht.framework.ioc.reader;

import com.linht.framework.ioc.bean.BeanDefinition;
import com.linht.framework.ioc.resource.ResourceLoader;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractBeanDefinitionReader implements BeanDefinitionReader {

    @Getter
    private Map<String,BeanDefinition> registry;

    @Getter
    private ResourceLoader resourceLoader;

    protected AbstractBeanDefinitionReader(ResourceLoader resourceLoader) {
        this.registry = new HashMap<>();
        this.resourceLoader = resourceLoader;
    }

}
