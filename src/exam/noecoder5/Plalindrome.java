package exam.noecoder5;

import java.util.Scanner;

/**
 * 制造回文
 * Created by ly on 2017/8/1.
 */
public class Plalindrome {
    public static boolean isPlalindrome(String s) {
        int length = s.length();
        int end1 = length/2-1;
        for(int i = 0; i <= end1; i++) {
            if(s.charAt(i) != s.charAt(length-1-i)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        char[] arr = new char[26];
        for(int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)-'a']++;
        }

        int res = 0;
        for (int i = 0; i < 26; i++) {
            if(arr[i] > 1) {
                if(arr[i] % 2 == 0) {
                    res += arr[i];
                }
                else {
                    res += (arr[i] - 1);
                }
            }
        }
        if(res > 0 && res < s.length() && res % 2 == 0) {
            res++;
        }
        if(res == s.length()) {
            System.out.println(1);
        }
        else if(res == 0) {
            System.out.println(s.length());
        }
        else {
            System.out.println(s.length()-res+1);
        }
    }
}
