package medium;

/**
 * 153题
 * Created by ly on 2017/8/31.
 */
public class FindMinInRotatedSortedArr {
    //时间复杂度O(n)遍历数组
    public static int findMin(int[] nums) {
        int start = nums[0];
        int min = start;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                start = nums[i];
                if(min > start) {
                    min = start;
                }
            }
        }
        return min;
    }

    //O(logn)的时间复杂度，二分查找的思路
    public static int findMin2(int[] nums) {
        int low = 0;
        int high = nums.length -1;
        if(nums[low] > nums[high]) {
            while (low != (high-1)) {
                int mid = (low+high)/2;
                if(nums[low] < nums[mid]) {
                    low = mid;
                }
                else high = mid;
            }
            return Math.min(nums[low], nums[high]);
        }
        return nums[0];
    }

    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        System.out.println(findMin(nums));
    }
}
