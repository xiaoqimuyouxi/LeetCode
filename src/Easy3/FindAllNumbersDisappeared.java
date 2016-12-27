package Easy3;

import java.util.ArrayList;
import java.util.List;

/**
 * 448题     找出数组中所有不包含的数字
 * 1 =< a[i] <= n   (其中n=a.length)
 * Created by ly on 2016/12/27.
 */
public class FindAllNumbersDisappeared {
    // Time Limit Exceeded      O(n)runtime,O(1)runspace
    public List<Integer> findDisappearedNumbers(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++) {
            if(list.contains(nums[i])) {
                continue;
            }
            list.add(nums[i]);
        }
        int j = 1;
        while(j <= n) {
            if(list.contains(j)) {
                list.remove((Integer)j);
                j++;
                continue;
            }
            list.add(j);
            j++;
        }
        return list;
    }

    //18ms
    public List<Integer> findDisappearedNumbers1(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int a : nums) {
            nums[Math.abs(a)-1] = -Math.abs(nums[Math.abs(a)-1]);
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }

    //18ms
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for(int a : nums) {
            int val = Math.abs(a)-1;
            if(nums[val] > 0) {
                nums[val] = -nums[val];
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }

    //17ms
    public List<Integer> findDisappearedNumbers3(int[] nums) {
        int n = nums.length;
        List<Integer> list = new ArrayList<>();
        for(int i = 0; i < n; i++)  nums[(nums[i]-1)%n] += n;
        for(int i = 0; i < n; i++)  if(nums[i] <= n) list.add(i+1);
        return list;
    }

    public static void main(String[] args) {
        int[] a = {1,2,3,5,6,8,3,2};
        FindAllNumbersDisappeared f = new FindAllNumbersDisappeared();
        System.out.println(f.findDisappearedNumbers3(a));
    }
}
