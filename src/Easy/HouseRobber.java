package Easy;

public class HouseRobber {

	public static int rob(int[] nums){
		int a = 0;
		int b = 0;
		for(int i = 0; i < nums.length; i++){
			if(i%2 == 0){
				a = Math.max(a+nums[i], b);
			}
			else
				b = Math.max(a, b+nums[i]);
		}
		return Math.max(a, b);
	}
	
	public static void main(String[] args) {
		int[] nums = {20, 15, 2, 5, 3, 4, 89, 25, 5};
		System.out.println(rob(nums));
	}

}
