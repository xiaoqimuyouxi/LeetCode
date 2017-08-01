package JVMexercise.classLoad;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ly on 2017/7/18.
 */
public class ClassLoaderTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader myLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                String filename = name.substring(name.lastIndexOf(".") + 1) + ".class";

                InputStream is = getClass().getResourceAsStream(filename);
                if(is == null) {
                    return super.loadClass(name);
                }
                try {
                    byte[] b = new byte[is.available()];
                    is.read(b);
                    return defineClass(name, b, 0, b.length);
                } catch (IOException e) {
                    throw new ClassNotFoundException(name);
                }
            }
        };

        Object obj = myLoader.loadClass("JVMexercise.classLoad.ClassLoaderTest").newInstance();

        /*
        * 第二行输出结果是false是因为，在虚拟机中出现了两个ClassLoaderTest类，一个是由系统应用程序类加载器加载的，另一个是由自定义的类加载器加载的，
        * 虽然都来自同一个class文件，但依然是两个独立的类。
        * */

        System.out.println(obj.getClass());
        System.out.println(obj instanceof JVMexercise.classLoad.ClassLoaderTest);
    }
}
