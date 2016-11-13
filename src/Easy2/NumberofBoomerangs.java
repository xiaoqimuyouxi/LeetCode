package Easy2;

import java.util.HashMap;

/**
 * 447题
 * 找出距离相同的点对
 * Created by ly on 2016/11/13.
 */
public class NumberofBoomerangs {
    //397ms
    public int numberOfBoomerangs(int[][] points) {
        int count = 0;
        int n = points.length;
        for(int i = 0; i < n; i++) {
            //需要创建n个map
            HashMap<Integer, Integer> map = new HashMap<>();
            for(int j = 0; j < n; j++) {
                int dis = (points[i][0]-points[j][0])*(points[i][0]-points[j][0])
                        + (points[i][1]-points[j][1])*(points[i][1]-points[j][1]);
                if(!map.containsKey(dis)) {
                    map.put(dis, 0);
                }
                //如果map中之前没有dis，那么第一次出现dis这个距离，count值加0
                //如果map中之前有dis,那么出现至少两次dis，点对排序方法*2
                count += map.get(dis)*2;
                map.put(dis, map.get(dis)+1);
            }
        }
        return count;
    }
}
