package exam.noecoder5;

import java.util.Scanner;

/**
 * 最长连续的DNA片段
 * Created by ly on 2017/8/1.
 */
public class DNA {
    //匹配字符
    public static boolean compareCharacter(char c) {
        if(c == 'A' || c == 'T' || c == 'C' || c == 'G') {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int res = 0;
        int max = Integer.MIN_VALUE;
        char[] arr = s.toCharArray();
        for(int i = 0; i < arr.length; i++) {
            if(compareCharacter(arr[i])) {
                res++;
            }
            else {
                if(max < res) {
                    max = res;
                }
                res = 0;
            }
            if(max < res) {
                max = res;
            }
        }
        System.out.println(max);
    }
}
