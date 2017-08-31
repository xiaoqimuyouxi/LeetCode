package exam.dynamicProgramming;

/**
 * 最大子数组和 LeetCode 53  Easy
 *
 * 一个整数数组，一个非空的子数组（连续的一段数），使得他的和最大
 *
 * dp[i] 表示以a[i]结尾的最大子数组的和
 * dp[i] = max{dp[i-1]+a[i], a[i]}
 *      包含a[i-1]: dp[i-1]+a[i]
 *      不包含a[i-1]: a[i]
 * 初值： dp[0] = a[0]
 * 答案是最大的dp[0..n-1]
 * 时间复杂度O(n)，空间复杂度O(n)
 *
 * 空间优化：dp[i]要存嘛？
 *      endHere = max(endHere+a[i], a[i])
 *      结果answer = max(endHere, answer)
 *
 * Created by ly on 2017/8/31.
 */
public class MaxSubArr {
    public int maxSubArr(int[] A, int n) {
        int[] dp = new int[n];
        dp[0] = A[0];
        int answer = dp[0];
        for (int i = 1; i < n; i++) {
            dp[i] = Math.max(dp[i-1] + A[i], A[i]);
            answer = Math.max(answer, dp[i]);
        }
        return answer;
    }

    //空间优化
    public int maxSubArr2(int[] A, int n) {
        int endHere = A[0];
        int answer = A[0];
        for (int i = 0; i < n; i++) {
            endHere = Math.max(endHere+A[i], A[i]);
            answer = Math.max(answer, endHere);
        }
        return answer;
    }
}
