package JVMexercise.classLoad;

/**
 * Created by ly on 2017/7/18.
 */
public class DeadLoopClass {
    static {
        /* 如果不加上这个if语句，编译器将提示"Initializer does not complete normally"，并拒绝编译 */
        if(true) {
            System.out.println(Thread.currentThread() + " init DeadLoopClass");
            while (true) {

            }
        }
    }

    public static void main(String[] args) {
        Runnable script = new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread() + " start.");
                DeadLoopClass dead = new DeadLoopClass();
                System.out.println(Thread.currentThread() + " over.");
            }
        };
        Thread thread1 = new Thread(script, "线程1");
        Thread thread2 = new Thread(script, "线程2");
        thread1.start();
        thread2.start();
    }
}
