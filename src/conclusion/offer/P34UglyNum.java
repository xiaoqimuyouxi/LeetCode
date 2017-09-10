package conclusion.offer;

/**
 * 测试用例：
 *  1. 功能测试（2,3,4,5,6等）
 *  2. 特殊测试（边界值1，无效输入0）
 *  3. 性能测试（1500等比较大的数）
 * Created by ly on 2017/9/3.
 */
public class P34UglyNum {
    //由于丑数只能被2，3,5整除，所以连续除2,3,5后若得到的数是1，那么就是丑数，如果不是1就不是丑数
    public static boolean isUgly(int num) {
        while (num%2 == 0)
            num /= 2;
        while (num%3 == 0)
            num /= 3;
        while (num%5 == 0)
            num /= 5;
        return (num == 1) ? true : false;
    }

    public static int GetUglyNumber_Solution(int index) {
        if(index <= 0) {
            return 0;
        }
        int num = 0;
        int count = 0;
        while (count < index) {
            num++;
            if(isUgly(num)) {
                count++;
            }
        }
        return num;
    }

    //不需要在非丑数上做任何计算，时间效率有明显提升
    public static int GetUglyNumber_Solution1(int index) {
        if(index <= 0) {
            return 0;
        }
        int[] uglyNums = new int[index];
        uglyNums[0] = 1;
        int next = 1;
        int p2 = 0;
        int p3 = 0;
        int p5 = 0;

        while (next < index) {
            int min = min(uglyNums[p2]*2, uglyNums[p3]*3, uglyNums[p5]*5);
            uglyNums[next] = min;

            while (uglyNums[p2]*2 <= min)
                p2++;
            while (uglyNums[p3]*3 <= min)
                p3++;
            while (uglyNums[p5]*5 <= min)
                p5++;
            next++;
        }
        int ugly = uglyNums[index-1];
        return ugly;
    }
    public static int min(int x1, int x2, int x3) {
        int min = Math.min(x1, x2);
        min = Math.min(x3, min);
        return min;
    }

    public static void main(String[] args) {
        System.out.println(GetUglyNumber_Solution1(11));
    }
}
