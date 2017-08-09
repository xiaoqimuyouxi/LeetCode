package exam.nowcoder;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 输入的第一行表示节点的个数n（1 ≤ n ≤ 1000，节点的编号为0到n-1）组成，
 下面是n-1行，每行有两个整数，第一个数表示父节点的编号，第二个数表示子节点的编号

 输入
 5
 0 1
 0 2
 1 3
 1 4

 输出
 3
 * Created by ly on 2017/8/8.
 */
public class HeightOFTree {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] ancestor = new int[n];
        for (int i = 0; i < n; i++) {
            ancestor[i] = i;
        }
        int height = 0;
        for(int i = 1; i < n; i++) {
            int parent = scanner.nextInt();
            int child = scanner.nextInt();

            ancestor[child] = parent;
        }

        for (int i = 0; i < n; i++) {
            height = Math.max(height, find(ancestor, i));
        }
        System.out.println(height+1);
    }

    public static int find(int[] ancestor, int i) {
        int high = 0;
        while (i != ancestor[i]) {
            high++;
            i = ancestor[i];
        }
        return high;
    }
}
