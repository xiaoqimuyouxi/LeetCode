package conclusion.offer.baidu;

import java.util.Scanner;

/**
 * 一个数轴上共有N个点，第一个点的坐标是度度熊现在位置，第N-1个点是度度熊的家。现在他需要依次的从0号坐标走到N-1号坐标。
 但是除了0号坐标和N-1号坐标，他可以在其余的N-2个坐标中选出一个点，并直接将这个点忽略掉，问度度熊回家至少走多少距离？

 输入：
 4
 1 4 -1 3

 输出：
 4
 * Created by ly on 2017/5/5.
 */
public class GoHome {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] rows = new int[n];
        for (int i = 0; i < n; i++) {
            rows[i] = scanner.nextInt();
        }

        int shortestRes = Integer.MAX_VALUE;
        for (int i = 1; i < rows.length-1; i++) {
            int tmp = 0;    //把第i个点去掉后的总长度
            for(int j = 0; j < rows.length-1; j++) {
                if(i-1 != j) {
                    tmp += Math.abs(rows[j+1]-rows[j]);
                }
                else {
                    tmp += Math.abs(rows[j+2]-rows[j]);
                    j++;
                }
            }
            if(tmp < shortestRes) {
                shortestRes = tmp;
            }
        }
        System.out.println(shortestRes);
    }
}
