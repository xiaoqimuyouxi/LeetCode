package exam.dynamicProgramming;

/**
 * Created by ly on 2017/8/31.
 */
public class BackPack {
    public int maxValue(int n, int V, int[] value, int[] weight) {
        int[][] dp = new int[n+1][1500];
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= V; j++) {
                if(weight[i] <= j) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-weight[i]]+value[i]);
                }
                else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[n][V];
    }

    public int maxValue2(int n, int V, int[] value, int[] weight) {
        int[] dp = new int[1500];
        for (int i = 1; i <= n; i++) {
            for (int j = V; j >= 1 ; j++) {
                if(weight[i] <= j) {
                    dp[j] = Math.max(dp[j], dp[j-weight[i]]+value[i]);
                }
            }
        }
        return dp[V];
    }
}
