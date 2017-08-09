package exam.nowcoder4;

import java.util.Scanner;

/**
 * Created by ly on 2017/8/8.
 */
public class WiteBlack {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] arr = str.trim().toCharArray();

        int res = 0;
        for (int i = 1; i < arr.length; i+=2) {
            if(i == arr.length-1) { //最后一张
                if(arr[i-1] == arr[i]) {
                    res++;
                    change(arr, i);
                }
            }
            else {
                if(arr[i] == arr[i-1] && arr[i] == arr[i+1]) {
                    res++;
                    change(arr, i);
                }
                else if(arr[i] == arr[i-1]) {
                    res++;
                    change(arr, i-1);
                }
                else if(arr[i] == arr[i+1]) {
                    res++;
                    change(arr,i+1);
                }
            }
        }
        System.out.println(res);
    }

    public static void change(char[] arr, int i) {
        if(arr[i] == 'W') {
            arr[i] = 'B';
        }
        else {
            arr[i] = 'W';
        }
    }

    /**
     * 由题意得，要得到交替排列形式，只有BWBWBW....或者WBWBWB...两种可能。
     只需要用两个变量记录得到这两种形式串所需要的步数即可，输出最小值
     */
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int b = 0, w = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if((i&1) == 0) {
                if(c == 'W') {  //以W开头
                    b++;
                }
                else w++;
            }
            else {
                if(c == 'W') {
                    w++;
                }
                else b++;
            }
        }
        System.out.println(Math.min(b, w));
    }
}
