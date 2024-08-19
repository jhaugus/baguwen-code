import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ReflectBreakSingleton {
    public static void main(String[] args) {
        SingletonClass instance = SingletonClass.getInstance();

        try {
            Constructor<SingletonClass> declaredConstructor = SingletonClass.class.getDeclaredConstructor();
            declaredConstructor.setAccessible(true);
            SingletonClass singletonClass = declaredConstructor.newInstance();

            System.out.println(singletonClass == instance); // false;

        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        }
    }


}
