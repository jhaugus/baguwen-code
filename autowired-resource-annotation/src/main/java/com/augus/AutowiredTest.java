package com.augus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Autowired 先byType,再byName，所以只要类型为Bean，那么springboot就会启动报错，必须使用单例Bean
 */
@Service
public class AutowiredTest {

//    @Autowired
//    private Bean bean;


    @Autowired
    @Qualifier("beanOne")
    private Bean bean2;

    @Autowired
    Bean beanOne;

    @Autowired
    private BeanTwo beanTwo;


}
