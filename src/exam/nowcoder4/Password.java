package exam.nowcoder4;

import java.util.HashSet;
import java.util.Scanner;

/**
 * 该题类似于剑指offer中字符串的排列
 * Created by ly on 2017/8/8.
 */
public class Password {
    static int res = 0;
    static HashSet<Character> set = new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        char[] arr = str.trim().toCharArray();

        Permutation(arr, 0);

        System.out.println(res);
    }

    public static void Permutation(char[] arr, int start) {
        if(start == arr.length-1 && !set.contains(arr[start])) {
            res++;
            set.add(arr[start]);
        }
        else {
            for (int i = start; i < arr.length; i++) {
                if(i == start || arr[i] != arr[start]) {
                    swap(arr, i, start);
                    Permutation(arr, start+1);
                    swap(arr, i, start);
                }
            }
        }
    }

    public static void swap(char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //字符串的顺序是不变的，只需要依次去掉一个字符就可以
    //思路一：一个个去字符，存于set中
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < str.length(); i++) {
            StringBuilder sb = new StringBuilder(str);
            sb.deleteCharAt(i);
            set.add(sb.toString());
        }
        System.out.println(set.size());
    }

    //思路2：对于相邻的两个字符，如果相同的话，去除一个，得到的结果是相同的
//       问题转换为计算字符串当前字符是否和前面字符相同.
    public static void main3(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.next();
        int res = 1;
        for (int i = 1; i < str.length(); i++) {
            if(str.charAt(i-1) != str.charAt(i)) {
                res++;
            }
        }
        System.out.println(res);
    }
}
