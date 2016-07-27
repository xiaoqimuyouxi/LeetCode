package Easy;

import java.util.Arrays;

//1Ìâ
public class TwoSum {

	//41ms
	public static int[] twoSum(int[] nums, int target) {
		int[] result = new int[2];
		for(int i = 0; i < nums.length; i++) {
			for(int j = i+1; j < nums.length; j++) {
				if(nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					return result;
				}
			}
		}
		return result;
    }
	
	//5ms
	public static int[] twoSum2(int[] nums, int target) {
		int[] result = new int[2];
		int a=0,b=0;
		int[] nums2 = Arrays.copyOf(nums, nums.length);
		Arrays.sort(nums2);
		int start = 0, end = nums2.length-1;
		while(start < end) {
			int sum = nums2[start] + nums2[end];
			if(sum < target)
				start++;
			else if(sum > target)
				end--;
			else {
				a = nums2[start];
				b = nums2[end];
				break;
			}
		}
		
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] == a) {
				result[0] = i;
				break;
			}
		}
		
		if(a != b) {
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] == b) {
					result[1] = i;
					break;
				}
			}
		}
		else {
			for(int i = 0; i < nums.length; i++) {
				if(nums[i] == b && i != result[0]) {
					result[1] = i;
					break;
				}
			}
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {-1,-2,-3,-4,-5};
		int target = -8;
		int[] a = twoSum2(nums, target);
		for(int i = 0; i < a.length; i++){
			System.out.print(a[i]+"  ");
		}
		
	}
}
