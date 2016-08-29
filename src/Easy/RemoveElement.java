package Easy;


//27题
public class RemoveElement {

	//1ms
	public static int removeElement(int[] nums, int val) {
		if(nums == null) {
			return 0;
		}
		//两个指针变量
		int first = 0;
		int last = nums.length;
		while(first != last) {
			if(nums[first] != val) {
				first++;
			}
			else {
				last--;
				int temp = nums[first];
				nums[first] = nums[last];
				nums[last] = temp;
			}
		}
		return last;
    }
	
	//1ms
	public static int removeElement2(int[] nums, int val) {
		int m = 0;
		for(int i = 0; i < nums.length; i++) {
			if(nums[i] != val) {
				nums[m] = nums[i];
				m++;
			}
		}
		return m;
	}
	
	public static void main(String[] args) {
		int[] nums = {4,5};
		int val = 4;
		System.out.println(removeElement2(nums, val));
	}
}
