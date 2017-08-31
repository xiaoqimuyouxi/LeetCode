package exam.dynamicProgramming;

/**
 * 二维数组路径最小和   LeetCode 64  Medium
 *
 * 一个m行n列的二维数组，每个元素是一个非负数，从左上角走到右下角，每次只能朝右或者下走，不能走出矩阵，使得总和最小
 *
 * dp[i][j]表示从左上到达(i, j)的最小值
 * dp[i][j] = min{dp[i-1][j], dp[i][j-1]} + a[i][j]
 *      从上边过来的dp[i-1][j] + a[i][j]
 *      从左边过来的dp[i]j-1[] + a[i][j]
 * 初值：（下标从0开始）
 *      dp[0][0] = a[0][0]
 *      dp[0][j>0] = dp[0][j-1] + a[0][j]
 *      dp[i>0][j] = dp[i-1][0] + a[i][0]
 *
 * 复杂度：时间 0(m*n),空间 O(m*n)
 *
 * Created by ly on 2017/8/31.
 */
public class MinPath {
    public static void main(String[] args) {
        int[][] grid = {{1,2,5}, {3,2,1}};
        System.out.println(minPathSum(grid));
    }

    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n]; //每个元素上的值表示从左上角起点走到该点时的最短路径长度
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0) {
                    if(j == 0) {
                        dp[i][j] = grid[i][j];
                    }
                    else {  //从左到右走第一行
                        dp[i][j] = dp[i][j-1] + grid[i][j];
                    }
                }
                else if(j == 0) {   //从上到下走第一列
                    dp[i][j] = dp[i-1][j] + grid[i][j];
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
                }
            }
        }
        return dp[m-1][n-1];
    }

    //空间优化
    public static int minPathSum2(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0) {
                    if(j == 0) {
                        dp[j] = grid[i][j];
                    }
                    else {
                        dp[j] = dp[j-1] + grid[i][j];
                    }
                }
                else if(j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                }
                else {
                    dp[j] = Math.min(dp[j-1], dp[j]) + grid[i][j];
                }
            }
        }
        return dp[n-1];
    }
}
