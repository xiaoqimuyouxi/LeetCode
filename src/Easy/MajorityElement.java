package Easy;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MajorityElement {

	//36ms
	//169Ã‚
	public static int majority(int[] nums){
		int len = nums.length, halfN = 0;
		
		if(len % 2 == 0)	halfN = len/2;
		else	halfN = (len-1)/2;
		
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < len; i++){
			if(map.keySet().contains(nums[i])){
				int a = map.get(nums[i]);
				map.put(nums[i], ++a);
			}
			else
				map.put(nums[i], 1);
		}
		int tmp = 0;
		Object[] b = map.values().toArray();
		Arrays.sort(b);
		
		Set<Integer> kSet = map.keySet();
		if((int)b[b.length-1] > halfN)
			for(int k : kSet){
				if(b[b.length-1].equals(map.get(k))){
					tmp = k;
				}
			}
		return tmp;
		
	}
	
	//6ms
	public static int majority2(int[] nums){
		int len = nums.length, halfN = 0;
		if(len % 2 == 0)	halfN = len/2;
		else	halfN = (len-1)/2;
		
		Set<Integer> set = new HashSet<Integer>();
		int count;
		for(int i = 0; i < nums.length; i++){
			count = 0;
			if(!set.contains(nums[i])){
				for(int j = i; j < nums.length; j++){
					if(nums[j] == nums[i])
						count++;
				}
				set.add(nums[i]);
			}
			if(count > halfN)
				return nums[i];
		}
		return 0;
	}
	
	public static void main(String[] args) {
		int[] nums = {1,2,2,2,2,2,3,3,5};
		System.out.println(majority2(nums));
	}

}
