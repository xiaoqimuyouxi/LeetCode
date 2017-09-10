package exam;

import java.util.Scanner;

/**
 * Created by ly on 2017/9/10.
 */
public class didi {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int count = 0;
        int start = 0;
        int end = 0;
        while (end < n) {
            if(find(arr, start, end)) {
                count++;
                start = end+1;
                end = start;
            }
            else end++;
        }
        System.out.println(count);

        /*Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < n-1; i++) {
            if(arr[i] == 0) {
                count++;
                continue;
            }
            for (int j = i+1; j < n; j++) {
                int res = arr[i];
                for (int k = arr[i]+1; k <= arr[j]; k++) {
                    res ^= k;
                }
                if(res == 0) {
                    count++;
                }
            }
        }
        System.out.println(count);*/

//        findNext(0, arr, 0);
//        System.out.println(max);

    }
    public static boolean find(int[] arr, int start, int end) {
        int cur = 0;
        for (int i = end; i >= start ; i--) {
            cur = cur ^ arr[i];
            if (cur == 0) {
                return true;
            }
        }
        return false;
    }

    static int max = 0;
    public static void findNext(int start, int[] arr, int index) {
        if(index > max) {
            max = index;
        }
        int end = arr.length;
        for (int i = start; i < end; i++) {
            int next = find(i, arr);
            if(next < arr.length) {
                findNext(next+1, arr, index+1);
            }
            if(next+1 < end) {
                end = next+1;
            }
        }
    }

    public static int find(int start, int[] arr) {
        int value = arr[start];
        if(value == 0) {
            return start;
        }
        int i = start+1;
        for (; i < arr.length; i++) {
            value ^= arr[i];
            if(value == 0) {
                return i;
            }
        }
        return i;
    }
}
