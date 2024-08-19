import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;

/**
 * 获取unsafe类的方法
 * 1. 利用反射获得 Unsafe 类中已经实例化完成的单例对象 theUnsafe 。
 * 2. 从getUnsafe方法的使用限制条件出发，通过 Java 命令行命令-Xbootclasspath/a把调用 Unsafe 相关方法的类 A 所在 jar 包路径追加到默认的 bootstrap 路径中，使得 A 被引导类加载器加载，从而通过Unsafe.getUnsafe方法安全的获取 Unsafe 实例。

 */

public class ReflectGetUnsafeClass {


    private static final Logger log = LoggerFactory.getLogger(ReflectGetUnsafeClass.class);

    private static Unsafe reflectGetUnsafe() {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            return (Unsafe) field.get(null);
        } catch (Exception e) {
            log.error(e.getMessage(), e);
            return null;
        }
    }

    public static void main(String[] args) {
        Unsafe unsafe = reflectGetUnsafe();
        System.out.println(unsafe);
    }

}
