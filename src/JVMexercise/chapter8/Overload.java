package JVMexercise.chapter8;

import java.io.Serializable;

/**
 * 方法静态分派演示
 * Created by ly on 2017/7/18.
 */
public class Overload {

    /* 8
    public static void sayHello(Object object) {
        System.out.println("hello object");
    }*/

    /* 2
    public static void sayHello(int arg) {
        System.out.println("hello int");
    }*/

    /* 3
    public static void sayHello(long arg) {
        System.out.println("hello long");
    }*/

    /* 4
    public static void sayHello(float arg) {
        System.out.println("hello float");
    }*/

    /* 5
    public static void sayHello(double arg) {
        System.out.println("hello double");
    }*/

    /* 6
    public static void sayHello(Character arg) {
        System.out.println("hello character");
    }*/

    // 10
    public static void sayHello(int... arg) {
        System.out.println("hello int...");
    }

    /* 1
    public static void sayHello(char arg) {
        System.out.println("hello char");
    }*/

    /* 9
    public static void sayHello(char... arg) {
        System.out.println("hello char...");
    }*/


    /**
     * 7
     * 后面两个方法优先级相同，所以必须在调用字符'a'时显示的指定字面量的静态类型才行
     *
     */
    /*public static void sayHello(Serializable arg) {
        System.out.println("hello serializable");
    }*/

    /*public static void sayHello(Comparable arg) {
        System.out.println("hello comparable");
    }*/

    public static void main(String[] args) {
        sayHello('a');
    }
}
