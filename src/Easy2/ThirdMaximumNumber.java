package Easy2;

/**
 * 414题
 * 找出数组中第3大的数
 * @author ly
 *
 */
public class ThirdMaximumNumber {

	//13ms
	public static int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for(Integer n : nums) {
        	if(n.equals(max1) || n.equals(max2) || n.equals(max3))
        		continue;
        	if(max1 == null || n > max1) {
        		max3 = max2;
        		max2 = max1;
        		max1 = n;
        	}
        	else if(max2 == null || n > max2) {
        		max3 = max2;
        		max2 = n;
        	}
        	else if(max3 == null || n > max3)
        		max3 = n;
        }
        if(max3 == null)
        	return max1;
        return max3;
    }
	
	//[1,2,-2147483648]此时答案为2，编译出错
	public static int thirdMax1(int[] nums) {
		int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i]==max1 || nums[i]==max2 || nums[i]==max3)
				continue;
			if(max1==Integer.MIN_VALUE || nums[i] > max1) {
				max3 = max2;
				max2 = max1;
				max1 = nums[i];
			}
			else if(max2==Integer.MIN_VALUE || nums[i] > max2) {
				max3 = max2;
				max2 = nums[i];
			}
			else if(max3 == Integer.MIN_VALUE || nums[i] > max3) {
				max3 = nums[i];
			}
		}
		if(max3 == Integer.MIN_VALUE)
			return max1;
		return max3;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,-2147483648};
		System.out.println(thirdMax1(nums));
	}
}
