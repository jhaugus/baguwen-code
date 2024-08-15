## 一些需要代码解释的八股文

#### spring-bean-lifecycle
Bean的生命周期
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


