package exam.nowcoder3;

import java.util.Scanner;

/**
 * 排序子序列
 * Created by ly on 2017/8/29.
 */
public class SortedArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] data = new int[n];
        for (int i = 0; i < n; i++) {
            data[i] = scanner.nextInt();
        }

        int flag = 0;   //0表示相等，1表示递增，-1表示递减
        int res = 1;
        for (int i = 1; i < n; i++) {
            if(data[i] > data[i-1]) {   //递增序列
                if(flag == 0) {
                    flag = 1;
                }
                if(flag == -1) {
                    flag = 0;   //表示不符合条件，回复初始值，进行下次循环判断
                    res++;
                }
            }
            else if(data[i] < data[i-1]) {  //递减序列
                if(flag == 0) {
                    flag = -1;
                }
                if(flag == 1) {
                    flag = 0;
                    res++;
                }
            }
        }
        System.out.println(res);
    }
}
