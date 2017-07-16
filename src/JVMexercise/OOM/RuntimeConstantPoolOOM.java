package JVMexercise.OOM;

import java.util.ArrayList;
import java.util.List;

/**
 * 在JDK1.6以前，运行时常量池是分配在永久代中的，可以通过 -XX:PermSize 和 -XX:MaxPermSize限制方法区大小
 *
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * String.intern()是一个Native方法，它的作用是：如果字符串常量池中已经包含一个等于此String对象的字符串，则返回代表池中这个字符串的String对象；
 * 否则，将此String对象包含的字符串添加到常量池中
 *
 * 运行时常量池导致的内存溢出
 * Created by ly on 2017/7/15.
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        //使用List保持常量池引用，避免Full GC 回收常量池行为
        List<String> list = new ArrayList<>();
        //10MB 的PermSize在integer范围内足够产生OOM了
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }
}
