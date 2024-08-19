import java.io.*;

/**
 * 序列化破坏单例
 */
public class SerializableBreakSingleton {

    public static void main(String[] args) {
        try {
            ObjectOutputStream tempFile = new ObjectOutputStream(new FileOutputStream("tempFile"));
            tempFile.writeObject(SingletonClass.getInstance());
            File tempFile1 = new File("tempFile");
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(tempFile1));

            SingletonClass instance = (SingletonClass)objectInputStream.readObject();

            System.out.println(instance == SingletonClass.getInstance());
        } catch (IOException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }


}
