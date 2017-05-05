package conclusion.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 *
 * 一级台阶  一种跳法
 * 两级台阶两种跳法
 *
 * 当n>2时，假设有f(n)种跳法，第一次跳有两种选择：
 *      1）只跳一级：后面就有f(n-1)种跳法
 *      2）跳两级：后面就有f(n-2)种跳法
 * 所以总共是f(n) = f(n-1)+f(n-2)
 *
 * 即这也是一个斐波那契数列
 * Created by ly on 2017/5/5.
 */
public class JumpFloor {
    public int JumpFloor(int target) {
        if(target < 1) {
            return 0;
        }
        if(target == 1) {
            return 1;
        }
        if(target == 2) {
            return 2;
        }

        int plus1 = 1;
        int plus2 = 2;
        int plusN = 0;
        for (int i = 3; i <= target ; i++) {
            plusN = plus1 + plus2;

            plus1 = plus2;
            plus2 = plusN;
        }
        return plusN;
    }
}
