package Easy2;

/**
 * Created by ly on 2016/10/26.
 */
public class ClimbingStairs {
    /*
    * 采用递归的思想
    * 给定一个数n，有两种方法爬到第n阶：
    *   1）从第n-1阶爬一级楼梯
    *   2）从第n-2阶爬两级楼梯
    * Time Limit Exceeded
    * */
    public static int climbStairs(int n) {
        if(n == 1)  return 1;
        if(n == 2)  return 2;

        return climbStairs(n-1) + climbStairs(n-2);
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(44));
    }
}
