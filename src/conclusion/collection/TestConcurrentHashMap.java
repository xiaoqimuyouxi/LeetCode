package conclusion.collection;

import org.junit.Assert;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by ly on 2017/8/9.
 */
public class TestConcurrentHashMap {
    public static void main(String[] args) {
        ConcurrentHashMap<String, String> map = new ConcurrentHashMap();
        int[] buff = new int[12];
        int[] arr = buff.clone();
        map.put("id", "1");
        map.put("name", "Andy");
        map.put("sex", "男");

        String name = map.get("name");
        Assert.assertEquals(name, "Andy");

        int size = map.size();
        Assert.assertEquals(size, 3);
    }
}
