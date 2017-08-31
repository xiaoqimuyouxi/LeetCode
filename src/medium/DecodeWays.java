package medium;

/**
 * 91题
 *
 * （1）00：res[i]=0（无法解析，没有可行解析方式）；
 （2）10, 20：res[i]=res[i-2]（只有第二种情况成立）；
 （3）11-19, 21-26：res[i]=res[i-1]+res[i-2]（两种情况都可行）；
 （4）01-09, 27-99：res[i]=res[i-1]（只有第一种情况可行）；

 类似爬楼梯问题，但要加很多限制条件。
 定义数组number，number[i]意味着：字符串s[0..i-1]可以有number[i]种解码方法。
 回想爬楼梯问题一样，number[i] = number[i-1] + number[i-2]
 但不同的是本题有多种限制：
 第一： s[i-1]不能是0，如果s[i-1]是0的话，number[i]就只能等于number[i-2]
 第二，s[i-2,i-1]中的第一个字符不能是0，而且Integer.parseInt(s.substring(i-2,i))获得的整数必须在0到26之间。
 *
 * Created by ly on 2017/8/31.
 */
public class DecodeWays {
    public static int numDecodings(String s) {
        if(s == null || s.trim().length() < 1 || s.charAt(0) == '0') {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        int k = 0;
        for (int i = 2; i <= n; i++) {
            if(s.charAt(i-1) != '0') {
                dp[i] = dp[i-1];
            }
            if(s.charAt(i-2) != '0') {
                k = Integer.parseInt(s.substring(i-2, i));
                if(k > 0 && k <= 26) {
                    dp[i] += dp[i-2];
                }
            }
        }
        return dp[n];
    }

    public static void main(String[] args) {
        String s = "230";
        System.out.println(numDecodings(s));
    }
}
