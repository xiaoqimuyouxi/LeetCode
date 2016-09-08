package Easy;

import java.util.Arrays;

public class RemoveDuplicates {

	//1ms
	public static int removeDuplicates(int[] nums) {
		if(nums.length == 0) {
			return 0;
		}
        int index = 1;
		for(int i = 1; i < nums.length; i++) {
			if(nums[i] != nums[i-1]) {
				nums[index++] = nums[i];
			}
		}
		return index;
    }
	
	public static void main(String[] args) {
		int[] nums = {1,1,1,2,3,4,5,5,6,7,7,8,8,9,9,9};
		Arrays.sort(nums);
		System.out.println(removeDuplicates(nums));
	}
}
