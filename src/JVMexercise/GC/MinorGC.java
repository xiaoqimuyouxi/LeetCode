package JVMexercise.GC;

/**
 * VM args: gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8
 *
 * 新生代Minor GC
 * Created by ly on 2017/7/16.
 */
public class MinorGC {
    private static final int size = 1024*1024;

    public static void testAllocation() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2*size];
        allocation2 = new byte[2*size];
        allocation3 = new byte[2*size];
        allocation4 = new byte[4*size]; //出现一次minor GC
    }

    public static void main(String[] args) {
        testAllocation();
    }
}
