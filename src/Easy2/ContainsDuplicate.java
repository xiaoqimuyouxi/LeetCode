package Easy2;

import java.util.Arrays;
import java.util.HashSet;

/**
 * 217题
 * 判断数组中是否包含相同的数字
 * @author ly
 *
 */
public class ContainsDuplicate {

	//时间复杂度O(n)，空间复杂度O(n),13ms
	public static boolean containsDuplicate(int[] nums) {
        HashSet<Integer> set = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
        	if(set.contains(nums[i]))
        		return true;
        	set.add(nums[i]);
        }
        return false;
    }
	
	//超时
	public static boolean containsDuplicate1(int[] nums) {
		int first = 0;
		int end = nums.length-1;
		while(first < end) {
			if(nums[first] == nums[end])
				return true;
			end--;
			if(first == end) {
				first++;
				end = nums.length-1;
			}
		}
		return false;
	}
	
	//时间复杂度O(n^2)，空间复杂度O(1),但是和上面一样超时
	public static boolean containsDuplicate2(int[] nums) {
		for(int i = 0; i < nums.length; i++) {
			for(int j = i+1; j < nums.length; j++) {
				if(nums[i] == nums[j])
					return true;
			}
		}
		return false;
	}
	
	//时间复杂度O(nlogn)，空间复杂度O(1),但是和上面一样超时
	public static boolean containsDuplicate3(int[] nums) {
		Arrays.sort(nums);
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] == nums[i-1])
				return true;
		}
		return false;
	}
	
	//5ms
	public static boolean containsDuplicate4(int[] nums) {
		if(nums.length <= 1) {
			return false;
		}
		
		Arrays.sort(nums);
		int first = 0; 
		int end = nums.length - 1;
		
		while(first <= end) {
			if(nums[first] == nums[first+1])
				return true;
			if(nums[end] == nums[end-1])
				return true;
			first++;
			end--;
		}
		return false;
	}
	
	//4ms
	public static boolean containsDuplicate5(int[] nums) {
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for(int b : nums) {
			if(b < min) 
				min = b;
			if(b > max)
				max = b;
		}
		boolean[] a = new boolean[max-min+1];
		for(int b : nums) {
			if(a[b-min])
				return true;
			else
				a[b-min] = true;
		}
		return false;
	}
	
	public static void main(String[] args) {
		int[] nums = {2,2,3,4,9,6,5,7,8};
		System.out.println(containsDuplicate5(nums));
	}
}
