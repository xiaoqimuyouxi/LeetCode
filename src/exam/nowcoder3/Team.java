package exam.nowcoder3;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 组队竞赛
 * 只对了90%，内存超限
 * Created by ly on 2017/8/29.
 */
public class Team {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        long[] arr = new long[3*n];
        for (int i = 0; i < 3*n; i++) {
            arr[i] = scanner.nextLong();
        }
        Arrays.sort(arr);
        int index = 2;
        long sum = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[arr.length-index];
            index += 2;
        }
        System.out.println(sum);
    }
}
