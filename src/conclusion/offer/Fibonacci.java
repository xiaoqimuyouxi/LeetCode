package conclusion.offer;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
 n<=39
 * Created by ly on 2017/5/5.
 */
public class Fibonacci {
    public static int Fibonacci(int n) {
        if(n <= 0 || n > 39) {
            return 0;
        }
        /*if(n == 1 || n == 2) {
            return 1;
        }*/
//        return Fibonacci(n-1)+Fibonacci(n-2);
        if(n == 1) {
            return 1;
        }

        int plus1 = 0;
        int plus2 = 1;
        int plusN = 0;

        for(int i = 2; i <= n; i++) {
            plusN = plus1+plus2;

            plus1 = plus2;
            plus2 = plusN;
        }
        return plusN;
    }

    static void Test(int n, int expected) {
        if(Fibonacci(n) == expected) {
            System.out.println("Succeed!");
        }
        else {
            System.out.println("Failed!");
        }
    }

    public static void main(String[] args) {
        Test(2, 1);
        Test(2, 2);
        Test(5, 5);
    }
}
