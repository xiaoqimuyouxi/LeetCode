package JVMexercise.chapter8;

/**
 * Created by ly on 2017/7/18.
 */
public class StaticDispatch {

    static abstract class Human {

    }

    static class Man extends Human {

    }

    static class Woman extends Human {

    }

    public void sayHello(Human human) {
        System.out.println("hello guy");
    }

    public void sayHello(Man man) {
        System.out.println("hello gentleman");
    }

    public void sayHello(Woman woman) {
        System.out.println("hello lady");
    }

    public static void main(String[] args) {
        Human man = new Man();
        Human woman = new Woman();

        StaticDispatch sr = new StaticDispatch();
        sr.sayHello(man);
        sr.sayHello(woman);
    }
}
