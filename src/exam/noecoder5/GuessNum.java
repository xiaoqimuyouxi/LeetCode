package exam.noecoder5;

import java.util.Scanner;

/**
 * 猜数游戏
 * Created by ly on 2017/8/1.
 */
public class GuessNum {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        System.out.println(guessNum(n));
    }

    public static long guessNum(int n) {
        boolean[] include = new boolean[n+1];
        long res = 1;
        for (int i = 2; i <= n; i++) {
            if(!include[i]) {
                int count = 1;
                for(int j = i; j <= n; j += i) {
                    include[j] = true;
                }
                for(long j = i; j <= n; j *= i) {
                    count++;
                }
                res = (res*count)%1000000007;
            }
        }
        return res;
    }
}
