package JVMexercise;

/**
 * VM args: -Xss128k
 *
 * 单线程下测试栈溢出异常
 * Created by ly on 2017/7/15.
 */
public class JavaVMStackSOF {
    private int stackLength = 1;

    //增大方法帧中本地变量表的长度
    public void stackLeak() {
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try {
            oom.stackLeak();
        } catch (Throwable e) {
            System.out.println("stack Length: "  + oom.stackLength);
            throw e;
        }
    }
}
