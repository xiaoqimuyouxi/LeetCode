package exam.nowcoder3;

import java.util.Scanner;

/**
 * 神奇数
 * Created by ly on 2017/8/29.
 */
public class MagicalNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int a = scanner.nextInt();
        int b = scanner.nextInt();

        int count = 0;
        for (int i = a; i <= b ; i++) {
            if (isMagical(i)) {
                count++;
            }
        }
        System.out.println(count);
    }

    //是否神奇数
    public static boolean isMagical(int n) {
        String s = String.valueOf(n);
        int k ;
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            for (int j = 0; j < s.length(); j++) {
                if(i != j) {
                    char c2 = s.charAt(j);
                    String t = String.valueOf(c1)+String.valueOf(c2);
                    k = Integer.parseInt(t);
                    if(isPrime(k) && k >= 10) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    //是否为质数
    public static boolean isPrime(int n) {
        if(n < 2) {
            return false;
        }
        boolean t = true;

        for (int i = 2; i*i <= n; i++) {
            if(n % i == 0)
                return false;
        }
        return true;
    }
}
