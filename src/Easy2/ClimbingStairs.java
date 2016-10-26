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

    /*
    * 斐波那契数列：0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, 144, ...
    * 裴波那契数列的第n项的值是第n阶楼梯的爬法的种类数
    * 0ms
    * */
    public static int climbStairs2(int n) {
        int a = 0, b = 1;
        int sum = 0;
        for(int i = 1; i <= n; i++) {
            sum = a+b;
            a = b;
            b = sum;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs2(44));
    }
}
