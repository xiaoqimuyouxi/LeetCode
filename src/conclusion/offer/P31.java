package conclusion.offer;

/**
 * 当前面子数组的和加上当前数字之后还比当前数字小的话就抛弃之前的子数组，从当前数字开始计算
 * Created by ly on 2017/8/14.
 */
public class P31 {
    boolean invalidInput = false;
    public int FindGreatestSumOfSubArray(int[] array) {
        if(array == null || array.length == 0) {
            invalidInput = true;
            return 0;
        }

        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            sum += array[i];
            if(sum < array[i]) {
                sum = array[i];
            }
            if(sum > max) {
                max = sum;
            }
        }
        return max;
    }

    public static void main(String[] args) {
        P31 p = new P31();
        int[] arr = {1,-2,3,10,-4,7,2,-5};
        System.out.println(p.FindGreatestSumOfSubArray(arr));
    }
}
