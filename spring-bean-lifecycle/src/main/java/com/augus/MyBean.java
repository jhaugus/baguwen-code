package com.augus;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class MyBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware, InitializingBean, DisposableBean {

    private String beanName;

//    @Autowired
//    public MyBean2 myBean2;

    public MyBean() {
        System.out.println("1. Bean 实例化 - 构造方法调用");
    }

    @Override
    public void setBeanName(String name) {
        this.beanName = name;
        System.out.println("2. 设置Bean的名称：" + name);
    }

    @Override
    public void setBeanFactory(org.springframework.beans.factory.BeanFactory beanFactory) throws BeansException {
        System.out.println("3. BeanFactoryAware接口的setBeanFactory方法调用");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("4. ApplicationContextAware接口的setApplicationContext方法调用");
    }

    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("5. InitializingBean接口的afterPropertiesSet方法调用 - 属性设置完成");
    }

    public void customInit() {
        System.out.println("6. 自定义init-method调用");
    }

    @Override
    public void destroy() throws Exception {
        System.out.println("7. DisposableBean接口的destroy方法调用");
    }

    public void customDestroy() {
        System.out.println("8. 自定义destroy-method调用");
    }
}
