package com.linht.framework.ioc.bean;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PropertyValue {

    private final String name;

    private final Object value;

}
