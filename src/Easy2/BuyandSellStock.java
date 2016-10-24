package Easy2;

/**
 * 121题
 * 买卖股票可以获得的最大利润
 * Created by ly on 2016/10/24.
 */
public class BuyandSellStock {
    /*
    * 当当天的股票值小于前期的低点时，才会去更新阶段最低股票值。
    * 也就是说，股票没有跌破前面几天的最低点的小波动，仍然被算作一个上升期。
    * 1ms   时间复杂度O(n)
    * */
    public static int maxProfit(int[] prices) {
        if(prices.length == 0)
            return 0;
        int min = prices[0];    //记录股票阶段性的低点
        int max = prices[0];    //记录股票阶段性的高点
        int d = 0;  //记录股票低点与高点的最大差值
        for(int i = 0; i < prices.length; i++) {
            if(prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
            else if(prices[i] > max) {
                max = prices[i];
                if(d < max - min)
                    d = max - min;
            }
        }
        return d;
    }

    public static void main(String[] args) {
        int[] a = {7,1,5,4,3,2};
        int[] b = {};
        System.out.println(maxProfit(b));
    }
}
