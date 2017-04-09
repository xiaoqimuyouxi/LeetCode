package conclusion;

/**
 * 单例模式总结
 *  特点：1）单例模式类构造器私有化 private
 *      2）在该类内部产生该类的实例化对象 private static
 *      3）定义一个静态方法返回该类的实例
 *
 * 注意：
 * 1、如果单例由不同的类装载器装载，则有可能产生不同的实例
 * 2、如果Singleton实现了java.io.Serializable接口，那么这个实例就可能被序列化和复原
 * Created by ly on 2017/4/9.
 */
public class Singleton {

}

//饿汉式，线程安全，效率低，在一开始就实例化对象，而不是要用的时候才实例化，这样容易消耗内存
class Singleton1 {
    //私有化类构造器
    private Singleton1() {

    }
    //饿汉式类加载的时候就直接实例化对象
    private static Singleton1 instance = new Singleton1();

    public static Singleton1 getInstance() {
        return instance;
    }
}

//懒汉模式，线程不安全特定条件下可以节约内存
class Singleton2 {
    private Singleton2() {

    }
    private static Singleton2 instance;
    public static Singleton2 getInstance() {
        if(instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}

//懒汉式，线程安全，但是效率很低，因为99%的情况几乎都不需要同步
class Singleton3 {
    private Singleton3() {

    }
    private static Singleton3 instance;
    public static synchronized Singleton3 getInstance() {
        if(instance == null) {
            instance = new Singleton3();
        }
        return instance;
    }
}

class Singleton4 {
    private Singleton4() {

    }
    private static volatile Singleton4 instance;
    public static Singleton4 getInstance() {
        if(instance == null) {
            synchronized (Singleton4.class) {
                if(instance == null) {
                    instance = new Singleton4();
                }
            }
        }
        return instance;
    }
}
