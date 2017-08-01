package exam.noecoder5;

import java.util.Scanner;

/**
 * 贴瓷砖
 * Created by ly on 2017/8/1.
 */
public class Tile {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        int min = -1;
        int res = 0;
        char[] arr = s.toCharArray();
        int j = 0;
        while (j < 2) {
            res = 0;
            for(int i = j; i < arr.length; i+=2) {
                if (i == 0 && i+1 < arr.length) {
                    if(arr[i] == arr[i+1]) {
                        res++;
                    }
                }
                else if(i == arr.length-1 && i-1 >= 0) {
                    if(arr[i] == arr[i-1]) {
                        res++;
                    }
                }
                else {
                    if(arr[i] == arr[i+1] || arr[i] == arr[i-1]) {
                        res++;
                    }
                }
            }
            if(min < 0 || min > res) {
                min = res;
            }
            j++;
        }


        System.out.println(min);
    }
}
