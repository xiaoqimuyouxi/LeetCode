package Easy3;

/**
 * 485题     求二进制数组中连续为1的个数（最大值）
 * Created by ly on 2017/1/18.
 */
public class MaxConsecutiveOnes {
    //11ms
    public int findMaxConsecutiveOnes(int[] nums) {
        int max = 0;
        int cur = 0;
        for (int i = 0; i < nums.length; i++) {
            if(nums[i] == 1) {
                cur++;
            }
            else {
                cur = 0;
            }
            max = max < cur ? cur : max;
        }
        return max;
    }

    //11ms
    public int findMaxConsecutiveOnes1(int[] nums) {
        int max = 0, maxHere = 0;
        for (int n : nums) {
            max = Math.max(max, maxHere = n == 0 ? 0 : maxHere+1);
        }
        return max;
    }

    public static void main(String[] args) {
        MaxConsecutiveOnes m = new MaxConsecutiveOnes();
        int[] nums = {1,1,0,1,1,1};
        System.out.println(m.findMaxConsecutiveOnes1(nums));
    }
}
