import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
/**
 * @reflect 反射的基本使用
 */
class Person {
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String greet() {
        return "Hello, my name is " + name + " and I am " + age + " years old.";
    }
}

public class ReflectionExample {
    public static void main(String[] args) {
        try {


            Class<?> personClass = Class.forName("com.augus.Person");
            // 获取Person类的Class对象

            System.out.println("---------- constructors ------------");
            Constructor<?>[] constructors = personClass.getConstructors();
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }


            System.out.println("---------- declaredField ------------");
            for (Field declaredField : personClass.getDeclaredFields()) {
                System.out.println(declaredField.getName());
            }

            System.out.println("---------- mothods ------------");
            for (Method declaredMethod : personClass.getDeclaredMethods()) {
                System.out.println(declaredMethod.getName());
            }


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
