package exam.nowcoderHuaWei;

import java.util.Scanner;

/**
 * Created by ly on 2017/8/16.
 */
public class HighestScore {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] score = new int[n+1];
            for (int i = 1; i < n+1; i++) {
                score[i] = scanner.nextInt();
            }
            for (int i = 0; i < m; i++) {
                String str = scanner.next();
                char c = str.charAt(0);
                int a = scanner.nextInt();
                int b = scanner.nextInt();

                if(c == 'Q') {
                    int max = Integer.MIN_VALUE;
                    if(a > b) {
                        for (int j = b; j <= a; j++) {
                            if(max < score[j]) {
                                max = score[j];
                            }
                        }
                    }
                    else {
                        for (int j = a; j <= b; j++) {
                            if(max < score[j]) {
                                max = score[j];
                            }
                        }
                    }
                    System.out.println(max);
                }
                else if(c == 'U') {
                    score[a] = b;
                }
            }
        }
        scanner.close();
    }
}
