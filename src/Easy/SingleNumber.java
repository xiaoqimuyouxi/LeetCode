package Easy;

import java.util.Arrays;

//136��
public class SingleNumber {

	//9ms
	public static int singleNumber(int[] nums) {
        Arrays.sort(nums);   //����
        int i = 0;
        int size = nums.length;
        if(size == 1) {
        	return nums[0];
        }
        while(i < size-1) {
        	if(nums[i] == nums[i+1]) 
        		i += 2;
        	else
        		return nums[i];
        }
        if(i == size-1) {
        	return nums[size-1];
        }
        return 0;
    }
	
	//1ms   ���ö����Ƶ�������㣬��ͬΪ0��ͬΪ1
	public static int singleNumber2(int[] nums) {
		int n = nums.length;
		int result = 0;
		for(int i = 0; i < n; i++) {
			result ^= nums[i];
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,1,2,3,4,5,4,3};
		System.out.println(singleNumber2(nums));
	}
}
