package exam.nowcoder4;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 也是类似于排列
 * 依次固定数组中其中一个数，然后与它后面的数依次交换，结果中相同的舍弃
 * Created by ly on 2017/8/8.
 */
public class ExchangeSequence {
    //内存超限
    static HashSet<String> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        if(n < 2 || n > 50) {
            return;
        }

        Permutation(arr, 0);
        System.out.println(set.size());

        scanner.close();
    }

    public static void Permutation(int[] arr, int start) {
        for (int i = start+1; i < arr.length; i++) {
            swap(arr, start, i);
            set.add(change(arr));
            swap(arr, start, i);
            Permutation(arr, start+1);
        }
    }

    public static String change(int[] arr) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //找所有不同的元素，设置flag，如果数组中有相同的元素，flag=true，则返回mount + 1，如果没有返回mount
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }

        int mount = 0;
        boolean flag = false;
        for (int i = 0; i < n-1; i++) {
            for (int j = i+1; j < n; j++) {
                if(arr[i] == arr[j]) {
                    flag = true;
                }
                if(arr[i] != arr[j]) {
                    mount++;
                }
            }
        }
        if(flag) {
            System.out.println(mount+1);
        }
        else System.out.println(mount);
    }
}
