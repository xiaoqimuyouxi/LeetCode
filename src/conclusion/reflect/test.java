package conclusion.reflect;

/**
 * 虚拟机在加载class文件的阶段，把类信息保存在方法区数据结构中，并在java堆中生成一个class对象，
 * 作为类信息的入口
 *
 * 获取class对象的三种方式
 * Created by ly on 2017/4/10.
 */
public class test {
    public static void main(String[] args) {
        //1.通过类实例变量获取class对象
        Dog dog = new Dog();
        Class clazz = dog.getClass();

        //2.通过类名获取class对象，只会加载Dog类，并不会触发其类构造器的初始化
        Class clazz1 = Dog.class;

        //3.通过Class.forName(String className)方式，会触发类构造器初始化，如果想不初始化，可以加中间参数false
        //Class.forName("conclusion.reflect.Dog", false, Dog.class.getClassLoader())
        try {
            Class clazz2 = Class.forName("conclusion.reflect.Dog");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
