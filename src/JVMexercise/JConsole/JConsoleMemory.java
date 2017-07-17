package JVMexercise.JConsole;

import java.util.ArrayList;
import java.util.List;

/**
 * JConsole监视代码，以64KB/50毫秒的速度往java堆中填充数据
 * Created by ly on 2017/7/17.
 */
public class JConsoleMemory {
    //一个OOMObject对象大约占64KB空间
    static class OOMObject {
        public byte[] placeholder = new byte[64 * 1024];
    }

    public static void fillHeap(int num) throws InterruptedException {
        List<OOMObject> list = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            //稍作延时，另监视曲线的变化更加明显
            Thread.sleep(50);
            list.add(new OOMObject());
        }
        System.gc();
    }

    public static void main(String[] args) throws InterruptedException {
        fillHeap(1000);
    }
}
