package com.augus;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ResourceTest {


//    @Resource
//    private Bean bean;

//    @Resource
//    private Bean customNameBean;

    @Resource
    private Bean beanOne;

    @Resource
    private Bean beanTwo;

    @Resource(type = BeanOne.class)
    private Bean bean2;
}
