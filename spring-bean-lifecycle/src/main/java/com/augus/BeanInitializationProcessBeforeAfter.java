package com.augus;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

@Component
public class BeanInitializationProcessBeforeAfter implements BeanPostProcessor {


    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("=============== " + beanName + "'postProcessBeforeInitialization =============== ");
        return BeanPostProcessor.super.postProcessBeforeInitialization(bean, beanName);
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("=============== " + beanName + "'postProcessAfterInitialization =============== ");
        return BeanPostProcessor.super.postProcessAfterInitialization(bean, beanName);
    }
}
