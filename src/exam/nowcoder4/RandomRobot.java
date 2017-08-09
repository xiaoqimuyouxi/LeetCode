package exam.nowcoder4;

import java.util.Arrays;
import java.util.Scanner;

/**
 * Created by ly on 2017/8/9.
 */
public class RandomRobot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        boolean[] b = new boolean[2*n+1];
        double res = 0;
        for (int t = 0; t < 100000; t++) {
            int p = n;
            Arrays.fill(b, false);
            for (int i = 0; i < n; i++) {
                if(Math.random() > 0.5) {
                    p--;
                }
                else {
                    p++;
                }
                b[p] = true;
            }
            for (int i = 0; i < 2*n; i++) {
                if(b[i]) {
                    res++;
                }
            }
        }
        System.out.printf("%.1f", res/100000);
    }
    public static void main2(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.printf("%.1f", trans(n));
    }

    public static double trans(int n) {
        if(n==1) {
            return 2.0;
        }
        if(n==2) {
            return 2.5;
        }
        if(n%2 == 1) {
            return trans(n-1)*(2*n)/(2*n-1);
        }
        else {
            return trans(n-1)*(2*n+1)/(2*n);
        }
    }
}
