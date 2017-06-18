package conclusion.offer;

/**
 * Created by ly on 2017/6/18.
 */
public class P8MinNumberInRotateArray {
    public static int minNumberInRotateArray(int[] array) {
        if(array == null || array.length == 0) {
            return 0;
        }
        int start = 0;
        int end = array.length-1;
        int result = 0;
        while (start < end) {
            if(array[start] < array[end]) {
                result = array[start];
                break;
            }
            else {
                start++;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3, 4, 5, 1, 2};
        System.out.println(minNumberInRotateArray(arr));
    }
}
