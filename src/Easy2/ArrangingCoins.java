package Easy2;

/**
 * 441题
 * n个硬币按行排列，第k排有k个硬币，求总共的行数（不包括最后不满的一行）
 * Created by ly on 2016/12/8.
 */
public class ArrangingCoins {
    /**
     * 用while(sum<=n)时候会超时
     * 此种方法耗时56ms
     * @param n
     * @return
     */
    public int arrangeCoins(int n) {
        if(n <= 1 && n >= 0)
            return n;
        if(n < 0)
            return 0;

        int i = 0;
        while(n >= 0) {
            i++;
            n -= i;
        }
        return i-1;
    }

    /**
     * sum=(x+1)*x/2,那么当sum是n的时候可得到x的值
     * 但是Math.sqrt()方法非常耗时，最后结果超时
     * @param n
     * @return
     */
    public int arrangeCoins1(int n) {
        if(n <= 1 && n >= 0)
            return n;
        if(n < 0)
            return 0;

        return (int)(Math.sqrt(8*(double)n+1)-1)/2;
    }

    public static void main(String[] args) {
        ArrangingCoins a = new ArrangingCoins();
        System.out.println(a.arrangeCoins1(8));
    }
}
