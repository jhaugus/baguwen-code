import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class JdkDynamicProxy implements InvocationHandler {
    private final Object target;

    public JdkDynamicProxy(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(proxy.getClass() + "的"  + method.getName()  + "方法正在启动");
        Object invoke = method.invoke(target, args);
        System.out.println(proxy.getClass() + "的"  + method.getName()  + "方法结束");
        return invoke;
    }
}
