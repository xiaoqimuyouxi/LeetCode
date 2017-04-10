package conclusion.reflect;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 反射机制reflect可以在运行期间获取指定类的字段、方法、父类和接口等信息
 * Created by ly on 2017/4/10.
 */
public class ReflectTest {
    public static void main(String[] args) {
        //利用反射获得类的字段
        Class clazz = Dog.class;    //没有初始化类构造器
        Field[] fields = clazz.getDeclaredFields();
        System.out.println("获取字段：");
        for (int i = 0; i < fields.length; i++) {
            System.out.print(fields[i].getName() + " ");
        }
        System.out.println();

        //利用反射获得类的方法
        Dog dog = new Dog();
        Class clazz1 = dog.getClass();
        Method[] methods = clazz1.getDeclaredMethods();
        //通过method.invoke(obj, ...args)可以调用obj实例的method方法
        System.out.println("获取方法：");
        for (int i = 0; i < methods.length; i++) {
            System.out.print(methods[i].getName() + " ");
        }
        System.out.println();

        //利用反射获得构造器信息
        try {
            Class clazz2 = Class.forName("conclusion.reflect.Dog");
            //如果没有显示的默认构造器，那么会抛出NoSuchMethodException异常
            Constructor constructor = clazz2.getConstructor(String.class, int.class);
            System.out.println("获取类构造器：");
            constructor.newInstance("Tom", 10);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
