import java.io.Serializable;

/**
 * 双检加锁的单例模式
 */

public class SingletonClass implements Serializable {

    private volatile static SingletonClass instance;

    public SingletonClass() {
    }

    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}
