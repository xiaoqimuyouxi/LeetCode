package JVMexercise;

/**
 * VM args: -Xss2M  (这时候设置的大一些，创建在虚拟机栈和本地方法栈中出现内存溢出的异常)
 *
 * 创建线程导致内存溢出异常
 * Created by ly on 2017/7/15.
 */
public class JavaVMStackOOM {
    private void dontStop() {
        while (true) {

        }
    }

    public void stackLeakByThreads() {
        while (true) {
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    dontStop();
                }
            });
            thread.start();
        }
    }

    public static void main(String[] args) {
        JavaVMStackOOM oom = new JavaVMStackOOM();
        oom.stackLeakByThreads();
    }
}
