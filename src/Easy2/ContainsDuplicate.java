package Easy2;

import java.util.HashSet;

/**
 * 217题
 * 判断数组中是否包含相同的数字
 * @author ly
 *
 */
public class ContainsDuplicate {

	//13ms
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
	
	public static void main(String[] args) {
		int[] nums = {2,2,3,4,9,6,5,7,8};
		System.out.println(containsDuplicate1(nums));
	}
}
