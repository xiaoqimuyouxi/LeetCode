package exam.noecoder5;

import java.util.Scanner;

/**
 * 偶串
 * Created by ly on 2017/8/1.
 */
public class even {
    public static boolean isEven(String s) {
        int start2 = s.length()/2;
        if(s.length() % 2 != 0) {
            return false;
        }

        for(int i = 0; i < start2; i++) {
            if(s.charAt(i) != s.charAt(i+start2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.next();
        for(int i = 1; i < s.length()-1; i++) {
            String str = s.substring(0, s.length()-i);
            if(isEven(str)) {
                System.out.println(str.length());
                return;
            }
        }
        System.out.println(0);
    }
}
