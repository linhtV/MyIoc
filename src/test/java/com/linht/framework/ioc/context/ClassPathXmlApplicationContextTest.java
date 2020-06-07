package com.linht.framework.ioc.context;

import com.linht.framework.ioc.entity.Robot;
import org.junit.Test;

import static org.junit.Assert.*;

public class ClassPathXmlApplicationContextTest {

    @Test
    public void test() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("myioc.xml");
        Robot robot = (Robot) applicationContext.getBean("robot");
        robot.show();
    }

}