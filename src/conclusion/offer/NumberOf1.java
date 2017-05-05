package conclusion.offer;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 * Created by ly on 2017/5/5.
 */
public class NumberOf1 {

    public int NumberOf1(int n) {
        /*//容易引起死循环
        int count = 0;
        while (n != 0) {
            if((n & 1) == 1) {
                count++;
            }
            n >>>= 1;
        }
        return count;*/

        /*//输入是2147483648则不可以
        int count = 0;
        int flag = 1;
        while (flag > 0) {
            if((n & flag) > 0) {
                count++;
            }
            flag <<= 1;
        }
        return count;*/

        //把一个整数减去1，再和原整数做与运算，会把该整数最右边的一个1变成0，
        //那么一个整数的二进制表示中有多少个1，就可以进行多少次这样的操作。
        int count = 0;
        while(n != 0) {
            count++;
            n = (n-1) & n;
        }
        return count;
    }

}
