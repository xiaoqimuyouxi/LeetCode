package exam.nowcoder4;

import java.util.Scanner;

/**
 * Created by ly on 2017/8/8.
 */
public class Expand {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int a = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
            if(a == arr[i]) {
                a = a*2;
            }
        }
        System.out.println(a);
        scanner.close();
    }
}
