package com.linht.framework.ioc.resource;

import org.junit.Assert;
import org.junit.Test;

import java.io.InputStream;

import static org.junit.Assert.*;

public class ResourceLoaderTest {
    @Test
    public void getResource() throws Exception {

        ResourceLoader resourceLoader = new ResourceLoader();
        Resource resource = resourceLoader.getResource("myioc.xml");
        InputStream inputStream = resource.getInputStream();
        Assert.assertNotNull(inputStream);
    }

}