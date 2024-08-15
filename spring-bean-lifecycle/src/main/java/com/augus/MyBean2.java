package com.augus;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyBean2 implements BeanNameAware{
    public String name = "mybean2";
    private String beanName;
    @Override
    public void setBeanName(String s) {
        this.beanName = s;
    }
}
