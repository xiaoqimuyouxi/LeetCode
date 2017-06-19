package conclusion.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * Created by ly on 2017/5/5.
 */
public class JumpFloorII {
    //由数学归纳法可以得到f(n)=2^(n-1)
    public int JumpFloorII(int target) {
        if(target <= 0) {
            return 0;
        }
        int res = 1;
        for(int i = 1; i < target; i++) {
            res *= 2;
        }
        return res;
    }
}