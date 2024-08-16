import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CglibDynamicProxy implements MethodInterceptor {
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println(o.getClass() + "的"  + method.getName()  + "方法正在启动");
        Object invoke = methodProxy.invokeSuper(o, objects);
        System.out.println(o.getClass() + "的"  + method.getName()  + "方法结束");
        return invoke;
    }


}
