package JVMexercise.classLoad;

/**
 *
 * Created by ly on 2017/7/18.
 */
public class SuperClass {
    static {
        System.out.println("SuperClass init！");
    }
    public static int value = 123;
}

class SubClass extends SuperClass {
    static {
        System.out.println("SubClass init !");
    }
}

class ConstClass {
    static {
        System.out.println("ConstClass init !");
    }

    public static final String HELLOWORLD = "hello world";
}

class NotInitialization {
    /**
     * 被动引用例子1
     * 对于静态字段，只有直接定义这个字段的类才会被初始化，因此通过子类来引用父类中定义的静态字段，只会触发父类的初始化而不会触发子类的初始化。
     * @param args
     */
    /*public static void main(String[] args) {
        System.out.println(SubClass.value);
    }*/

    /**
     * 被动引用例子2
     * 通过数组定义来引用类，不会触发此类的初始化
     * @param args
     */
    /*public static void main(String[] args) {
       SuperClass[] superClasses = new SuperClass[10];
    }*/

    /**
     * 被动引用例子3
     * 常量在编译阶段会存入调用类的常量池中，本质上并没有直接引用到定义常量的类，因此不会触发定义常量的类的初始化
     * @param args
     */
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}
