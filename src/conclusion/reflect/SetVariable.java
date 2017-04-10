package conclusion.reflect;

import java.lang.reflect.Field;

/**
 * 通过反射设置变量
 * Created by ly on 2017/4/10.
 */
public class SetVariable {
    public static void main(String[] args) {
        Class clazz = Dog.class;
        try {

            //设置私有变量
            Field field = clazz.getDeclaredField("name");
            field.setAccessible(true);
            Dog dog = (Dog) clazz.newInstance();    //通过class对象的newInstance方法生成对象实例
            field.set(dog, "Tom");  //给dog实例的name属性设置成Tom


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }

    }
}
