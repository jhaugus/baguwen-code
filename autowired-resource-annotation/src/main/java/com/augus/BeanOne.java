package com.augus;

import org.springframework.beans.factory.annotation.Autowire;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
@Component("beanOne")
public class BeanOne implements Bean {
    @Override
    public String[] value() {
        return new String[0];
    }

    @Override
    public String[] name() {
        return new String[0];
    }

    @Override
    public Autowire autowire() {
        return null;
    }

    @Override
    public boolean autowireCandidate() {
        return false;
    }

    @Override
    public String initMethod() {
        return "";
    }

    @Override
    public String destroyMethod() {
        return "";
    }

    @Override
    public Class<? extends Annotation> annotationType() {
        return null;
    }
}
