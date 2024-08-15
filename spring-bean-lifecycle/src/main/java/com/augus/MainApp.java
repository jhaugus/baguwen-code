package com.augus;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;


@ComponentScan("com.augus") // 请确保包名与实际的Bean类所在包一致
public class MainApp {
    public static void main(String[] args) {
        // 创建Spring应用程序上下文
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainApp.class);

        System.out.println("================== Spring Application Context created ===============");

        MyBean myBean = (MyBean) context.getBean(MyBean.class);
        System.out.println("正在使用bean");
        myBean.getAnotherBean();

        MyBean2 bean = context.getBean(MyBean2.class);
        bean.setBeanName("augus");


        System.out.println("================== Spring Application Context closed ===============");
        // 关闭上下文
        context.close(); // 7. 8
    }

}
