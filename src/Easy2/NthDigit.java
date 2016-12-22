package Easy2;

/**
 * 400题     将1到无穷大的数全部串在一起，求出第n位是什么数
 * Created by ly on 2016/12/22.
 */
public class NthDigit {
    //n=10000000时， Memory Limit Exceeded
    public int findNthDigit(int n) {
        StringBuilder res = new StringBuilder();
        for(int i = 1; i <= n; i++) {
            res.append(i);
        }
        return res.toString().charAt(n-1)-48;
    }

    //6ms
    public int findNthDigit1(int n) {
        int start = 1, len = 1;
        long count = 9;
        while (n > len*count) {
            n -= len*count;
            len++;
            start *= 10;
            count *= 10;
        }
        start += (n-1)/len;
        return String.valueOf(start).charAt((n-1)%len)-'0';
    }

    public static void main(String[] args) {
        NthDigit d = new NthDigit();
        System.out.println(d.findNthDigit1(11));
    }
}
