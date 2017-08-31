package exam.dynamicProgramming;

/**
 * 编辑距离  LeetCode 72 Hard
 *
 * 给定两个字符串S和T，求把S变成T所需要的最少操作次数。操作包括：在任意位置增加一个字符，减少任意一个字符以及修改任意一个字符
 *
 * dp[i][j]表示S的前i个位置和T的前j个位置对齐的最少得分
 * dp[i][j] = min{dp[i-1][j-1] + same(i,j), dp[i-1][j] +1, dp[i][j-1]+1}
 *      dp[i-1][j-1] + same(i,j)  对应S的第i个字符和T的第j个字符对齐
 *      dp[i-1][j]+1  对应S第i个字符和-对齐，即删掉S中第i个字符
 *      dp[i][j-1]+1  对应T的第j个字符和-对齐，即在S中加入该字符
 * 初值：dp[0][j] = j,  dp[i][0] = i (i >= 0, j >= 0)
 *
 * 时空复杂度 O(lengthS*lengthT)
 * 空间优化：省掉一维
 *      对每个i，正向循环j
 *          注意保存dp[i-1][j-1]因为j-1已经是“新值”
 * Created by ly on 2017/8/31.
 */
public class EditDistance {
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m+1][n+1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if(i == 0) {
                    dp[i][j]  = j;
                }
                else if(j == 0) {
                    dp[i][j] = i;
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + (word1.charAt(i-1)==word2.charAt(j-1) ? 0:1), Math.min(dp[i-1][j]+1,
                            dp[i][j-1] + 1));
                }
            }
        }
        return dp[m][n];
    }

    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[] dp = new int[n+1];
        for (int i = 0; i <= m; i++) {
            int last = 0;
            for (int j = 0; j <= n ; j++) {
                if(i == 0) {
                    dp[j] = j;
                }
                else if(j == 0) {
                    last = dp[j];
                    dp[j] = i;
                }
                else {
                    // last = dp[i-1][j-1]
                    int temp = dp[j];
                    dp[j] = Math.min(last+(word1.charAt(i-1)==word2.charAt(j-1) ? 0:1), Math.min(dp[j]+1,
                            dp[j-1] + 1));
                    last = temp;
                }
            }
        }
        return dp[n];
    }

}
