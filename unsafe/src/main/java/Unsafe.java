import sun.misc.VM;
import sun.reflect.CallerSensitive;
import sun.reflect.Reflection;

/**
 * 调用unsafe方法，会对调用者的classLoader进行检查，
 * 判断当前类是否由Bootstrap classLoader加载，
 * 如果不是的话那么就会抛出一个SecurityException异常。
 * 也就是说，只有启动类加载器加载的类才能够调用 Unsafe 类中的方法，
 * 来防止这些方法在不可信的代码中被调用。
 * 为什么要对 Unsafe 类进行这么谨慎的使用限制呢?
 *
 * Unsafe 提供的功能过于底层（如直接访问系统内存资源、自主管理内存资源等），
 * 安全隐患也比较大，使用不当的话，很容易出现很严重的问题。
 */
public final class Unsafe {
  // 单例对象
    private static final Unsafe theUnsafe = null;

    private Unsafe() {
    }
    @CallerSensitive
    public static Unsafe getUnsafe() {
        Class var0 = Reflection.getCallerClass();
        // 仅在引导类加载器`BootstrapClassLoader`加载时才合法
        if(!VM.isSystemDomainLoader(var0.getClassLoader())) {
            throw new SecurityException("Unsafe");
        } else {
            return theUnsafe;
        }
    }

    public static void main(String[] args) {
        Unsafe.getUnsafe();
    }


}
