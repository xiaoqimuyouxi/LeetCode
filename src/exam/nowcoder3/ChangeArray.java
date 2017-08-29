package exam.nowcoder3;

import java.util.Scanner;

/**
 * 数组变换
 * Created by ly on 2017/8/29.
 */
public class ChangeArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
            if(min > a[i]) {
                min = a[i];
            }
        }

        for (int i = 0; i < n; i++) {
            if(a[i]%min != 0) {
                System.out.println("NO");
                return;
            }
            int k = a[i]/min;
            if(!is2(k)) {
                System.out.println("NO");
                return;
            }
        }
        System.out.println("YES");
    }

    public static boolean is2(int n) {
        if((n&(n-1)) == 0) {
            return true;
        }
        return false;
    }
}
