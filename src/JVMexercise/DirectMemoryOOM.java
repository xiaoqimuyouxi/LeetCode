package JVMexercise;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * 运行提示：最大堆内存设置无效
 * VM args: -Xmx:20M -XX:MaxDirectMemorySize=10M
 *
 * 本机直接内存溢出
 * Created by ly on 2017/7/15.
 */
public class DirectMemoryOOM {
    private static final int a = 1024*1024;

    public static void main(String[] args) throws IllegalAccessException {
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        while (true) {
            unsafe.allocateMemory(a);
        }
    }
}
