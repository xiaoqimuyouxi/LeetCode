package conclusion.reflect;

/**
 * Created by ly on 2017/4/10.
 */
public class Dog {
    private String name;
    private int age;
    static {
        System.out.println("Dog is load");
    }

    public Dog(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public Dog() {

    }
}

class Cat {
    private String name;
    private int age;
    static {
        System.out.println("Cat is load");
    }
}
