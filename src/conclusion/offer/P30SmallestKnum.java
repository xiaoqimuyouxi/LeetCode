package conclusion.offer;

import java.util.ArrayList;

/**
 * Created by ly on 2017/8/13.
 */
public class P30SmallestKnum {
    //利用快排的思路，时间复杂度O（n）
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input == null || input.length == 0 || k > input.length || k<=0) {
            return list;
        }

        int start = 0;
        int end = input.length-1;
        int index = partition(input, start, end);
        while (index != k-1) {
            if(index < (k-1)) {
                start = index+1;
                index = partition(input, start, end);
            }
            else {
                end = index-1;
                index = partition(input, start, end);
            }
        }
        for (int i = 0; i < k; i++) {
            list.add(input[i]);
        }
        return list;
    }

    public int partition(int[] arr, int low, int high) {
        int key = arr[low];
        while (low < high) {
            while (low < high && arr[high] >= key)
                high--;
            swap(arr, low, high);
            while (low < high && arr[low] <= key)
                low++;
            swap(arr, low, high);
        }
        return low;
    }
    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
