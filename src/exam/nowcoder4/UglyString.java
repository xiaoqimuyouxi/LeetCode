package exam.nowcoder4;

import java.util.Scanner;

/**
 * Created by ly on 2017/8/8.
 */
public class UglyString {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] arr = str.toCharArray();
        int k = 0;
        for (int i = 0; i < arr.length; i++) {
            if(i == 0) {
                //如果最开始是连续的几个?号，则可以肯定不会存在丑陋值
                while (i < arr.length && arr[i] == '?') {
                    i++;
                }
            }
            else {
                if(arr[i] == '?') {
                    change(arr, i); //和前一个不同
                }
                else if(arr[i-1] == arr[i]) {
                    k++;
                }
            }
        }
        System.out.println(k);
    }
    //将?换成和前一个字符不同的字符
    public static void change(char[] arr, int i) {
        if(arr[i-1] == 'A') {
            arr[i] = 'B';
        }
        else {
            arr[i] = 'A';
        }
    }
}
