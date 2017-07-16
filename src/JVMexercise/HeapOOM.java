package JVMexercise;

import java.util.ArrayList;
import java.util.List;

/**
 * VM args: -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError
 * 设置堆的最小值是20M，最大值也是20M，当两者相等时表示不可扩展，
 * 最后一个参数可以让虚拟机在出现内存溢出异常时Dump出当前的内存堆转储快照以便事后进行分析
 *
 * 测试堆溢出异常
 * Created by ly on 2017/7/15.
 */
public class HeapOOM {

    static class OOMObject {

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<>();

        //使对象的数量增大到最大堆的容量
        while (true) {
            list.add(new OOMObject());
        }
    }
}
