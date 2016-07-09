package Easy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Intersection {

	/*
	 * ʹ��list����ʱ����14ms
	 * 349��
	 */
	public static int[] intersection(int[] nums1, int[] nums2){
		int flag = 0;
		List<Integer> list = new ArrayList<Integer>();
		Arrays.sort(nums2);	//	�����������ƥ�䲻��0�����
		for(int i = 0; i < nums1.length; i++){
			//���ҵ��Ļ���������nums2�е�����ֵ������Ҳ������ظ�ֵ
			//����������������ʹ��binarySearch,������������Ԥ�ϵĽ��
			flag = Arrays.binarySearch(nums2, nums1[i]);	
			if(flag >= 0){
				if(list.contains(nums1[i]))  //��������ظ�������
					;
				else
					list.add(nums1[i]);
			}
		}
		int size = list.size();
		//listֻ��ת��ΪInteger���飬Integerת��Ϊint����ֻ����forѭ��ʵ��
		Integer[] result = list.toArray(new Integer[size]);
		int[] a = new int[size];
		for(int i = 0; i < size; i++){
			a[i] = result[i];
		}
		return a;
	}
	
	/*
	 * ʹ��set����ʱ����8ms
	 * set���ܴ洢ֵ��ͬ��Ԫ��
	 */
	public static int[] intersection2(int[] nums1, int[] nums2){
		int flag = 0;
		Set<Integer> set = new HashSet<Integer>();
		Arrays.sort(nums2);	//	�����������ƥ�䲻��0�����
		for(int i = 0; i < nums1.length; i++){
			//���ҵ��Ļ���������nums2�е�����ֵ������Ҳ������ظ�ֵ
			flag = Arrays.binarySearch(nums2, nums1[i]);	
			if(flag >= 0){
				set.add(nums1[i]);
			}
		}
		int size = set.size();
		//listֻ��ת��ΪInteger���飬Integerת��Ϊint����ֻ����forѭ��ʵ��
		Integer[] result = set.toArray(new Integer[size]);
		int[] a = new int[size];
		for(int i = 0; i < size; i++){
			a[i] = result[i];
		}
		return a;
	}
	
	/*
	 * ���ϵ�hashset������7ms
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
