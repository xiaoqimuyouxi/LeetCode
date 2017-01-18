package medium;

import java.util.HashMap;
import java.util.Map;

/**
 * 454题     求四个数组中在每个数组里任意找一个元素加起来和为0的个数
 * Created by ly on 2017/1/18.
 */
public class SumII {
    /*164ms
    * 时间复杂度O(n^2)
    * 空间复杂度O(n^2)
    * */
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < C.length; i++) {
            for(int j = 0; j < D.length; j++) {
                int sum = C[i] + D[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < B.length; j++) {
                int tmp = -1*(A[i]+B[j]);
                res += map.getOrDefault(tmp, 0);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        SumII s = new SumII();
        int[] A = {1, 2};
        int[] B = {-2, -1};
        int[] C = {-1, 2};
        int[] D = {0, 2};
        System.out.println(s.fourSumCount(A, B, C, D));
    }
}
