package conclusion.offer;

import java.util.Scanner;

/**
 * Created by ly on 2017/9/17.
 */
public class BinarySearch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int k = scanner.nextInt();
        System.out.println(binarySearch(arr, k));
    }

    //迭代
    public static int binarySearch(int[] arr, int target) {
        int mid = 0;
        int low = 0;
        int high = arr.length-1;
        while (low <= high) {
            mid = (low+high)/2;
            if(target == arr[mid]) {
                return mid;
            }
            else if(target < arr[mid]) {
                high = mid-1;
            }
            else low = mid+1;
        }
        return -1;
    }

    //递归
    public static int binarySearch(int[] arr, int target, int begin, int last) {
        int mid = (begin + last)/2;
        if(target < arr[begin] || target > arr[last] || begin > last) {
            return -1;
        }
        if(target < arr[mid]) {
            return binarySearch(arr, target, begin, mid-1);
        }
        else if(target > arr[mid]) {
            return binarySearch(arr, target, mid+1, last);
        }
        else return mid;
    }
}
