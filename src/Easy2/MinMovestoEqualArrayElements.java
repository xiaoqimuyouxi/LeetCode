package Easy2;

import java.util.HashSet;
import java.util.Set;

/**
 * 453题     最小的移动次数使得数组中元素相同
 * 每移动一次，需要将长度为n的数组中的n-1个元素加1
 *
 * 以后遇到这种题首先需要找出规律再求解，不然即使循环遍历做出来了也不是最佳方案！！
 * Created by ly on 2016/11/9.
 */
public class MinMovestoEqualArrayElements {
    //[1,2147483647]超时
    public static int minMoves(int[] nums) {
        if(nums.length <= 1)
            return 0;
        if(nums.length == 2)
            return Math.max(nums[0],nums[1])-Math.min(nums[0], nums[1]);
        Set<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        //System.out.println(set);
        int count = 0;
        while(set.size() > 1) {
            count++;
            set.clear();
            int max = nums[0];
            int sign = -1;
            for(int i = 0; i < nums.length; i++) {
                if(max < nums[i])
                    max = nums[i];
            }
            for(int i = 0; i < nums.length; i++) {
                if(sign >= 0 && max == nums[i]) {
                    nums[i]++;
                }
                else if(sign < 0 && max == nums[i])
                    sign = i;
                else if(max != nums[i])
                    nums[i]++;
                set.add(nums[i]);
                //System.out.print(nums[i] + ", ");
            }
            //System.out.println(set);
        }
        return count;
    }

    //19ms

    /**
     * 设最后相同的元素为x,移动的次数为m
     * 每次移动时，数组里的元素总和增加n-1，故有x*n-sum=m*(n-1)
     * 数组中值最小的元素肯定每次都需要加1，所以min+m=x
     * 由以上两个公式就可以得到m=sum-min*n
     *
     *
     * @param nums
     * @return
     */
    public static int minMoves1(int[] nums) {
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] < min)
                min = nums[i];
            sum += nums[i];
        }
        return sum - min*nums.length;
    }

    public static void main(String[] args) {
        int[] nums = {1,2147483647};
        System.out.println(minMoves1(nums));
    }
}
