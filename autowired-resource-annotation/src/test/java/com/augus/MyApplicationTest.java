package com.augus;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;


@SpringBootTest(classes = MyApplication.class)
public class MyApplicationTest {
    @Autowired
    private AutowiredTest autowiredTest;

    @Autowired
    private ResourceTest resourceTest;

    @Resource
    private BeanOne beanOne;
    @Test
    public void test() {
        System.out.println(autowiredTest);
        System.out.println(autowiredTest.beanOne);

        System.out.println(resourceTest);
        System.out.println(beanOne);
    }

}
