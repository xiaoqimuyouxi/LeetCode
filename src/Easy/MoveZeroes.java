package Easy;
import java.util.ArrayList;


public class MoveZeroes {

	public static void moveZero(int[] nums){
		ArrayList<Integer> al = new ArrayList<Integer>();
		for(int i = 0; i < nums.length; i++){
			al.add(nums[i]);
		}
		//al.contains(0)
		for(int j = al.size()-1; j >= 0; j--){
			if(al.get(j) == 0){
				al.remove(j);
				al.add(0);
			}
		}
		for(int k = 0; k < al.size(); k++){
			nums[k] = al.get(k);
		}
	}
	
	public static void moveZero2(int[] nums){
		int index = 0;
		for(int i = 0; i < nums.length; i++){
			if(nums[i] != 0){
				nums[index++] = nums[i];
			}
		}
		while(index < nums.length){
			nums[index++] = 0;
		}
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] nums = {12, 0, 2, 4, 1, 0, 2, 0, 56};
		moveZero2(nums);
		for(int i = 0; i < nums.length; i++){
			System.out.print(nums[i]+" ");
		}
		
	}

}
