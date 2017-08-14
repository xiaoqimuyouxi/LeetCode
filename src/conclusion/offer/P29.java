package conclusion.offer;

import java.util.Arrays;

/**
 * Created by ly on 2017/8/13.
 */
public class P29 {
    public int MoreThanHalfNum_Solution(int [] array) {
        int n = array.length;
        if(n == 1) {
            return array[0];
        }
        Arrays.sort(array);
        int maxLen = Integer.MIN_VALUE;
        int res = array[0];
        int temp = 1;
        for (int i = 1; i < n; i++) {
            if(array[i] == array[i-1]) {
                temp++;
            }
            else {
                if(maxLen < temp) {
                    maxLen = temp;
                    res = array[i-1];
                }
                temp = 1;
            }
        }
        if(maxLen <= n/2) {
            return 0;
        }
        return res;
    }

    public static void main(String[] args) {
        P29 p = new P29();
        int[] arr = {1,2,3,2,2,2,5,4,2};
        System.out.println(p.MoreThanHalfNum_Solution1(arr));
    }

    public boolean checkInvalidArray(int[] arr) {
        if(arr.length == 0 || arr == null) {
            return true;
        }
        return false;
    }

    public boolean checkMoreThanHalf(int[] arr, int num) {
        int len = 0;
        for (int i = 0; i < arr.length; i++) {
            if(arr[i] == num) {
                len++;
            }
        }

        if(len <= arr.length/2) {
            return false;
        }
        return true;
    }

    public int MoreThanHalfNum_Solution1(int [] array) {
        if(checkInvalidArray(array)) {
            return 0;
        }

        int mid = array.length / 2;
        int start = 0;
        int end = array.length-1;
        int index = partition(array, start, end);
        while (index != mid) {
            if(index > mid) {
                end = index-1;
                index = partition(array, start, end);
            }
            else {
                start = index + 1;
                index = partition(array, start, end);
            }
        }
        int result = array[mid];
        if(checkMoreThanHalf(array, result)) {
            return result;
        }
        return 0;
    }

    //O(n)
    public int partition(int[] arr, int start, int end) {
        int key = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= key)
                end--;
            swap(arr, start, end);
            while (start < end && arr[start] <= key) {
                start++;
            }
            swap(arr, start, end);
        }
        return start;
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public int MoreThanHalfNum_Solution2(int [] array) {
        if(checkInvalidArray(array)) {
            return 0;
        }

        int result = array[0];
        int count = 1;
        for (int i = 1; i < array.length; i++) {
            if(count == 0) {
                result = array[i];
                count = 1;
            }
            else if(array[i] == result) {
                count++;
            }
            else count--;
        }

        if(checkMoreThanHalf(array, result)) {
            return result;
        }
        return 0;
    }
}
