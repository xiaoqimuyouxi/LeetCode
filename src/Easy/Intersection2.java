package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Intersection2 {

	/**
	 * 6ms
	 */
	public static int[] intersection(int[] nums1, int[] nums2){
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums1);
		Arrays.sort(nums2);
		int i,k;
		for(i = k = 0;i < nums1.length && k < nums2.length;){
			if(nums1[i] == nums2[k]){
				list.add(nums1[i]);
				i++;
				k++;
			}
			else if(nums1[i] < nums2[k])
				i++;
			else
				k++;
		}
		int[] result = new int[list.size()];
		for(int j = 0; j < list.size(); j++)
			result[j] = list.get(j);
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = {1,3,5,7,8,3,3,3};
		int[] b = {2,3,5,4,3,3,7};
		int[] inter = intersection(a,b);
		for(int i = 0; i < inter.length; i++){
			System.out.print(inter[i] +" ");
		}
	}

}
