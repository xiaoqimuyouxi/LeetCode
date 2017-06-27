package conclusion.offer;

/**
 * 数值的整数次方
 * Created by ly on 2017/6/27.
 */
public class P11Power {
    //该解法只适合对正数次方求积，若exponent<0则不合适
    public static double power1(double base, int exponent) {
        double res = 1.0;
        for (int i = 1; i < exponent+1; i++) {
            res *= base;
        }
        return res;
    }

    /**
     * 1)由于0的0次方在数学上没有意义，所以无论输出0或1都可以
     * 2）如果是对0求倒数，则会出现异常情况。（底数base是0且指数是负数的时候）
     *
     */
    public static double power2(double base, int exponent) {
        //第一、二种情况
        if(equal(base, 0.0) && exponent <= 0) {
            return 0.0;
        }
        int absExponent = Math.abs(exponent);   //指数的绝对值
        double result = power1(base, absExponent);
        if(exponent < 0) {
            result = 1.0/result;
        }
        return result;
    }

    public static boolean equal(double num1, double num2) {
        if((num1 - num2) > -0.0000001 && (num1 - num2) < 0.0000001) {
            return true;
        }
        else
            return false;
    }

    /**
     * a^n = [a^(n/2)]*[a^(n/2)], n为偶数
     * a^n = [a^((n-1)/2)]*[a^((n-1)/2)]*a, n为奇数
     *
     */
    public static double power3(double base, int exponent) {
        if(exponent == 0) {
            return 1.0;
        }
        if(exponent == 1) {
            return base;
        }
        double res = power1(base, exponent >> 1);   //用右移运算代替除以2
        res *= res;
        if(exponent%2 == 1) {
            res *= base;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(power3(2.0, 3));
    }
}
