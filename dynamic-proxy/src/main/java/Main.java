import net.sf.cglib.proxy.Enhancer;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {

        StaticServiceImp staticServiceImp = new StaticServiceImp();

        JdkDynamicProxy jdkDynamicProxy = new JdkDynamicProxy(staticServiceImp);

        StaticService staticService = (StaticService) Proxy.newProxyInstance(
                staticServiceImp.getClass().getClassLoader(),
                staticServiceImp.getClass().getInterfaces(),
                jdkDynamicProxy
        );
        staticService.staticPerformTask();


        System.out.println("========================================");
        // cglib
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(StaticServiceImp.class);
        enhancer.setCallback(new CglibDynamicProxy());

        StaticService staticService2 = (StaticService) enhancer.create();
        staticService2.staticPerformTask2();

    }
}
