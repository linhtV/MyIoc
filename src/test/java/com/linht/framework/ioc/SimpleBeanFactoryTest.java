package com.linht.framework.ioc;

import com.linht.framework.ioc.bean.BeanDefinition;
import com.linht.framework.ioc.core.AbstractBeanFactory;
import com.linht.framework.ioc.core.SimpleBeanFactoryImpl;
import com.linht.framework.ioc.entity.Robot;
import com.linht.framework.ioc.reader.XmlBeanDefinitionReader;
import com.linht.framework.ioc.resource.ResourceLoader;
import org.junit.Test;

import java.util.Map;

public class SimpleBeanFactoryTest {

    @Test
    public void testLazy() throws Exception {

        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("myioc.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new SimpleBeanFactoryImpl();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.获取bean
        Robot robot = (Robot) beanFactory.getBean("robot");
        robot.show();

    }


    @Test
    public void testPreInstantiate() throws Exception {

        // 1.读取配置
        XmlBeanDefinitionReader xmlBeanDefinitionReader = new XmlBeanDefinitionReader(new ResourceLoader());
        xmlBeanDefinitionReader.loadBeanDefinitions("myioc.xml");

        // 2.初始化BeanFactory并注册bean
        AbstractBeanFactory beanFactory = new SimpleBeanFactoryImpl();
        for (Map.Entry<String, BeanDefinition> beanDefinitionEntry : xmlBeanDefinitionReader.getRegistry().entrySet()) {
            beanFactory.registerBeanDefinition(beanDefinitionEntry.getKey(), beanDefinitionEntry.getValue());
        }

        // 3.初始化bean
        beanFactory.preInstantiateSingletons();

        // 3.获取bean
        Robot robot = (Robot) beanFactory.getBean("robot");
        robot.show();

    }

}
