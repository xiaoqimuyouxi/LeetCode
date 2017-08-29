package exam.nowcoder3;

import java.util.Scanner;

/**
 * 变换次数
 * Created by ly on 2017/8/29.
 */
public class changeTimes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String s = String.valueOf(n);
        int count = 0;
        while (s.length() != 1) {
            int mul = 1;
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                mul *= Integer.valueOf(String.valueOf(c));
            }
            s = String.valueOf(mul);
            count++;
        }
        System.out.println(count);
    }
}
