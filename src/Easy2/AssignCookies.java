package Easy2;

import java.util.Arrays;

/**
 * 455题
 * 分饼干
 * Created by ly on 2016/11/16.
 */
public class AssignCookies {
    //17ms
    public int findContentChildren(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        //时间复杂度为O(nlogn)
        for(int i = 0; i < s.length && res < g.length; i++) {
            //排序之后如果g中较小的数都不小余s中的数，那就没必要再遍历下去
            if(s[i] >= g[res])
                res++;
        }
        return res;
    }

    //134ms
    public int findContentChildren1(int[] g, int[] s) {
        int res = 0;
        Arrays.sort(g);
        Arrays.sort(s);
        //时间复杂度为O(n^2)
        for(int i = 0; i < g.length; i++) {
            for(int j = 0; j < s.length; j++) {
                if(g[i] <= s[j]) {
                    res++;
                    s[j] = 0;
                    break;
                }
            }
        }
        return res;
    }
}
