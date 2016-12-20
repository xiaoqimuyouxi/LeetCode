package Easy2;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 219题     找出数组中邻接相差最大为K的相等的两个数
 * Created by ly on 2016/12/20.
 */
public class ContainsDuplicateII {
    //超时，时间复杂度为O(n^2)
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(nums.length <= 1)
            return false;
        for(int i = 0; i < nums.length; i++) {
            for(int j = i+1; j <= i+k && j < nums.length; j++) {
                if(nums[i] == nums[j])
                    return true;
            }
        }
        return false;
    }

    //12ms 空间换取时间，时间复杂度O(n),空间复杂度O(n)
    public boolean containsNearbyDuplicate1(int[] nums, int k) {
        if(nums.length <= 1)
            return false;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                if(i-map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    //8ms   Map每次插入数据需要计算hash值所以相比set比较慢
    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if(nums.length <= 1)
            return false;
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length; i++) {
            if(i > k) set.remove(nums[i-k-1]);
            if(!set.add(nums[i]))    return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ContainsDuplicateII c = new ContainsDuplicateII();
        int[] arr = {2,5,6,8,9,4,5};
        int[] arr2 = {1};
        System.out.println(c.containsNearbyDuplicate2(arr, 5));
    }
}
