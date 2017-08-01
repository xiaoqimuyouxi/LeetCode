package JVMexercise.classLoad;

/**
 * Created by ly on 2017/7/18.
 */
public class Test {
    //静态语句块中只能访问到定义在静态语句块之前的变量，定义在它之后的变量，在前面的静态语句块中可以对它进行赋值，但是不能访问
    static {
        i = 0;
//        System.out.println(i);  //非法向前引用
    }
    static int i = 1;

    static class Parent {
        public static int A = 1;
        static {
            A = 2;
        }
    }

    static class Sub extends Parent {
        public static int B = A;
    }

    public static void main(String[] args) {
        System.out.println(Sub.B);
    }
}
