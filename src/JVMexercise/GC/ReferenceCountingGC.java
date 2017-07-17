package JVMexercise.GC;


/**
 * 引用计数算法的缺陷
 *
 * Created by ly on 2017/7/16.
 */
public class ReferenceCountingGC {
    public Object instance = null;

    private static final int size = 1024*1024;

    //该成员变量的唯一意义是占点内存，以便能在GC日志中看清楚是否被回收过
    private byte[] bigSize = new byte[2*size];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;


        //假设在这行发生GC，objA和objB是否能被回收
        System.gc();
    }

    public static void main(String[] args) {
        testGC();
    }
}
