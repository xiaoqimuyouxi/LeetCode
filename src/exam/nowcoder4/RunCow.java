package exam.nowcoder4;

import java.util.Scanner;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 牛牛在农场饲养了n只奶牛,依次编号为0到n-1, 牛牛的好朋友羊羊帮牛牛照看着农场.有一天羊羊看到农场中逃走了k只奶牛,但是他只会告诉牛牛逃走的k只奶牛的编号之和能被n整除。你现在需要帮牛牛计算有多少种不同的逃走的奶牛群。因为结果可能很大,输出结果对1,000,000,007取模。
 例如n = 7 k = 4:
 7只奶牛依次编号为0到6, 逃走了4只
 编号和为7的有:{0, 1, 2, 4}
 编号和为14的有:{0, 3, 5, 6}, {1, 2, 5, 6}, {1, 3, 4, 6},{2, 3, 4, 5}
 4只牛的编号和不会大于18,所以输出5.

 数组中随机选取K个数的组合问题
 * Created by ly on 2017/8/8.
 */
public class RunCow {
    static int res = 0;
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int k = scanner.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = i;
        }
        int[] result = new int[k];
        int res = combine_increase(arr, 0, result, k, k, n);;
        System.out.println(res);
    }

    /**
     *
     * @param arr   原始数组
     * @param start 遍历起始位置
     * @param result    一维数组保存结果
     * @param count result数组的索引值
     * @param NUM   要选取的元素个数
     * @param arr_len   原始数组长度，为定值
     *
     *                  超时
     */
    static int combine_increase(int[] arr, int start, int[] result, int count, int NUM, int arr_len)
    {
        int i = 0;
        for (i = start; i < arr_len + 1 - count; i++)
        {
            result[count - 1] = i;
            if (count - 1 == 0)
            {
                int j;
                int sum = 0;
                for (j = NUM - 1; j >= 0; j--) {
//                    System.out.printf("%d\t",arr[result[j]]);
                    sum += arr[result[j]];
                }
                if(sum % arr_len == 0) {
                    res++;
                }
//                System.out.println();
            }
            else
                combine_increase(arr, i + 1, result, count - 1, NUM, arr_len);
        }
        return res;
    }

    public static int sum(int[] res) {
        int sum = 0;
        for (int i = 0; i < res.length; i++) {
            sum += res[i];
        }
        return sum;
    }

    /*链接：https://www.nowcoder.com/questionTerminal/2f050f7a6ea7439a84f294f0e16f53a3
    来源：牛客网*/
    /*
    * 链接：https://www.nowcoder.com/questionTerminal/2f050f7a6ea7439a84f294f0e16f53a3
来源：牛客网

在前i只牛中选取j只，使得他们的编号之和与n的余数为r，方式数为dp[i][j][r]。
- 如果不选取第i只牛，则选取方式数为在前i-1只牛中选取j只，方式数为dp[i-1][j][r]
- 如果选取第i只牛，则选取方式数为在前i-1只牛中选取j-1只，方式数为dp[i-1][j-1](r+n-i)%n]
因此：dp[i][j][r]=dp[i-1][j][r]+dp[i-1][j-1](r+n-i)%n]
状态压缩：dp[j][r]=dp[j][r]+dp[j-1](r+n-i)%n]
此时如果j从0到k，计算dp[i][j][r]时会覆盖掉dp[i-1][j][r]的值，因此需要从后往前计算
    * */
    private static final int mod = 1000_000_007;
/**
      * 从0~n-1的n个数中，取出k个
      * @param n n个数
      * @param k 取出k个
      * @return 组合数
      */
    public static int escapeFarm(int n, int k) {
        int[][] dp = new int[k+1][n]; //状态转移矩阵
        //初始赋值 ,i = 0时， 存在1个数，选出0个，余n为0,选出1个，余n为0，有1个
        dp[0][0] = dp[1][0] = 1;
        for (int i = 1; i < n; i++) {  //i 从1到n-1，算到n-1即为0~n-1中，选出k个数，其和余n为0
//            for (int j = 1; j <= Math.min(i+1, k); j++) {    //最少选1个数，最多选k个数
            for (int j = Math.min(i+1, k); j > 0; j--) {    //这个地方必须要倒序，因为j与j-1的值相关，即计算j时，j-1的值不能改变
                for (int l = 0; l < n; l++) {
                    dp[j][l] =(dp[j][l] + dp[j-1][(l-i+n)%n])%mod;
                }
            }
        }
        return dp[k][0];
    }
}
