package conclusion.overflow;

import java.util.ArrayList;

/**
 * 构造堆内存溢出的情形
 * Created by ly on 2017/8/23.
 */
public class heapLeak {
    public static void main(String[] args) {
        ArrayList<sub>  list = new ArrayList<>();
        while (true) {
            list.add(new sub());
        }
    }
    static class sub {

    }
}
