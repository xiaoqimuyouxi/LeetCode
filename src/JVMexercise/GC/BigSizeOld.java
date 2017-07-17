package JVMexercise.GC;

/**
 * VM args: -verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:+PrintGCDetails -XX:SurvivorRatio=8 -XX:PretenureSizeThreshold=3145728
 *
 * 大对象直接进入老年代
 * Created by ly on 2017/7/16.
 */
public class BigSizeOld {

    private static final int size = 1024*1024;

    public static void testPretenureSizeThreshold() {
        byte[] allocation;
        allocation = new byte[4*size];  //直接分配在老年代中
    }
}
