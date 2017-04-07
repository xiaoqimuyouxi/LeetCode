package exam;

import java.util.Scanner;

/**
 * 360笔试    跑步
 * 小明同学喜欢体育锻炼，他常常去操场上跑步。跑道是一个圆形，在本题中，我们认为跑道是一个半径为R的圆形，设圆心的坐标为原点(0,0)。
 小明跑步的起点坐标为(R,0)，他沿着圆形跑道跑步，而且一直沿着一个方向跑步。回到家后，他查看了自己的计步器，计步器显示他跑步的总路程为L。
 小明想知道自己结束跑步时的坐标，但是他忘记自己是沿着顺时针方向还是逆时针方向跑的了。他想知道在这两种情况下的答案分别是多少。
 *
 * 跑到圆心（0,0），半径R，已知从（R，0）开始跑了L长度，但不知道是顺时针还是逆时针跑的，求跑步结束时的终点坐标
 * Created by ly on 2017/3/18.
 */
public class Running {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int L = s.nextInt();
        int R = s.nextInt();

        double k  = L % (2*Math.PI*R);  //终点离起点的弧长
        double a = k/R; //弧长除半径是角度
        double x = Math.cos(a);
        double y1 = Math.sin(a);
        double y2 = -y1;
        System.out.printf("%.3f %.3f\n", x, y1);
        System.out.printf("%.3f %.3f", x, y2);
    }
}
