package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Intersection {

	/*
	 * 使用list运行时间是14ms
	 * 349题
	 */
	public static int[] intersection(int[] nums1, int[] nums2){
		int flag = 0;
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums2);	//	不加这句会出现匹配不到0的情况
		for(int i = 0; i < nums1.length; i++){
			//查找到的话返回数在nums2中的索引值，如果找不到返回负值
			//必须对已排序的数组使用binarySearch,否则会产生不可预料的结果
			flag = Arrays.binarySearch(nums2, nums1[i]);	
			if(flag >= 0){
				if(list.contains(nums1[i]))  //避免出现重复的数字
					;
				else
					list.add(nums1[i]);
			}
		}
		int size = list.size();
		//list只能转换为Integer数组，Integer转换为int数组只能用for循环实现
		Integer[] result = list.toArray(new Integer[size]);
		int[] a = new int[size];
		for(int i = 0; i < size; i++){
			a[i] = result[i];
		}
		return a;
	}
	
	/*
	 * 使用set运行时间是8ms
	 * set不能存储值相同的元素
	 */
	public static int[] intersection2(int[] nums1, int[] nums2){
		int flag = 0;
		Set<Integer> set = new HashSet<Integer>();
		Arrays.sort(nums2);	//	不加这句会出现匹配不到0的情况
		for(int i = 0; i < nums1.length; i++){
			//查找到的话返回数在nums2中的索引值，如果找不到返回负值
			flag = Arrays.binarySearch(nums2, nums1[i]);	
			if(flag >= 0){
				set.add(nums1[i]);
			}
		}
		int size = set.size();
		//list只能转换为Integer数组，Integer转换为int数组只能用for循环实现
		Integer[] result = set.toArray(new Integer[size]);
		int[] a = new int[size];
		for(int i = 0; i < size; i++){
			a[i] = result[i];
		}
		return a;
	}
	
	/*
	 * 网上的hashset方法，7ms
	 */
	public static int[] intersection3(int[] nums1, int[] nums2){
		HashSet<Integer>nums1Set = new HashSet<Integer>();
        HashSet<Integer>nums2Set = new HashSet<Integer>();
        HashSet<Integer>resSet = new HashSet<Integer>();
        
        for (int i = 0; i < nums1.length; i++){
            nums1Set.add(nums1[i]);
        }
        for (int i = 0; i < nums2.length; i++){
            nums2Set.add(nums2[i]);
        }
        Iterator<Integer> iter = nums1Set.iterator();
        while (iter.hasNext()){
            Integer next = iter.next();
            if (nums2Set.contains(next)){
                resSet.add(next);
            }
        }
        int[]res = new int[resSet.size()];
        Iterator<Integer>resIterator = resSet.iterator();
        int index = 0;
        while(resIterator.hasNext()){
            res[index] = resIterator.next();
            index++;
        }
        return res;
	}
	
	public static void main(String[] args) {
		int[] a = {0,1,2,2,1,0,5};
		int[] b = {2,2,0,5};
		//int[] result = intersection(a, b);
		int[] result2 = intersection2(a,b);
		for(int i = 0; i < result2.length; i++){
			System.out.print(result2[i]+" ");
		}
		
	}

}
