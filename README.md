# 一些需要代码解释的八股文

## @Autowired和@Resource的区别

autowired-resource-annotation


在Spring容器中两者是相同的作用

1. byName和byType的不同

   @Autowired是先byType匹配，如果匹配不到，则byName匹配

   @Resource是先byName匹配，如果匹配不到，则byType匹配

   两者只是方式不同而已，只要使用正确都是可以的

2. 作用域不同

   Autowired可以作用在属性、setter和构造器上

   Resource 只能作用在属性、setter上

3. 支持方不同

Autowired由Spring框架提供，Resource由JDK提供，Resource有更好的迁移性

4. 默认要求不同

   我认为这点才是最重要的，如果找不到Bean，则@Autowired会抛出异常，而@Resource会返回null

```java
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
class BeanOne implements Bean {

}

@Component
class BeanTwo implements Bean {

}
public class test {
    // 错误使用方式
    @Autowired
    private Bean bean;
    @Resource
    private Bean bean;
    
    // 正确使用方式
    @Autowired
    private Bean beanOne;
    @Resource
    private Bean beanOne;
    @Resource(type = BeanTwo.class)
    private Bean beanName;
}
```
@Autowired：通过类型匹配进行依赖注入，如果匹配到多个bean，则通过名称匹配进行依赖注入，如果匹配不到，则抛出异常。
@Resource：通过名称匹配进行依赖注入，如果匹配不到，则通过类型匹配进行依赖注入，如果匹配到多个bean，则抛出异常。



## 手写动态代理
dynamic-proxy

## 反射基本使用、反射破坏单例模式
reflect 

 反射让我们的代码更加灵活、为框架提供开箱即用的功能提供了便利。

但是也有一些安全和效率问题。例如，反射忽略泛型参数的安全检查，性能也较低。





## Bean的生命周期

spring-bean-lifecycle

1. 创建实例：无参构造方法创建
3. 依赖注入：构造方法注入、setter注入、字段注入
```java
@Component
public class ServiceA {
    private final ServiceB serviceB;

    // 通过构造函数注入依赖
    public ServiceA(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public void doSomething() {
        serviceB.performTask();
    }
}

@Component
public class ServiceB {
    public void performTask() {
        System.out.println("ServiceB 执行任务");
    }
}
```
```java
@Component
public class ServiceA {
    private ServiceB serviceB;

    // 通过Setter方法注入依赖
    @Autowired
    public void setServiceB(ServiceB serviceB) {
        this.serviceB = serviceB;
    }

    public void doSomething() {
        serviceB.performTask();
    }
}
@Component
public class ServiceB {
    public void performTask() {
        System.out.println("ServiceB 执行任务");
    }
}
```
```java
@Component
public class ServiceA {

    @Autowired
    private ServiceB serviceB; // 字段注入

    public void doSomething() {
        serviceB.performTask();
    }
}

@Component
public class ServiceB {
    public void performTask() {
        System.out.println("ServiceB 执行任务");
    }
}
```
4. Aware注入
   1. BeanNameAwre接口
   2. BeanClassLoaderAware接口
   3. BeanFactoryAware接口
   4. ApplicationContextAware接口
   5. ResourceLoaderAware接口
   6. EnvelopeAware接口
   7. EnvironmentAware接口

Aware注入的目的是为了更好让该Bean与Spring的其他组件进行交互


BeanPostProcessor接口实现postProcessorBeforeInitialization和postProcessorAfterInitialization方法
5. postProcessorBeforeInitialization：初始化前的工作
6. initializingBean：初始化Bean
7. initMethod：自定义初始化方法
7. postProcessorAfterInitialization：初始化后的Bean功能强化
8. DisposableBean：销毁Bean
9. detoryMethod：自定义销毁方法




## unsafe详解
unsafe
