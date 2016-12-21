/**
 * 几种排序算法总结
 * Created by ly on 2016/12/20.
 */
public class SortDemo {
    /**
     * 冒泡排序
     * 时间复杂度O(n^2)
     * @param arr
     * @return
     */
    public static int[] bubbleSort(int[] arr) {
        if(arr.length <= 1)
            return arr;
        //需要arr.length次循环，每一次循环找出当前循环中最大的数
        for(int i = 0; i < arr.length-1; i++) {
            //每次找到的最大的数沉到最末尾以后不再比较这个数
            for(int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = tmp;
                }
            }
        }
        return arr;
    }

    /**
     * 插入排序
     * @param arr
     * @return
     */
    public static int[] insertSort(int[] arr) {
        if(arr.length <= 1)     return arr;
        for(int i = 0; i < arr.length-1; i++) {
            if(arr[i] > arr[i+1]) {
                int tmp = arr[i];
                arr[i] = arr[i+1];
                arr[i+1] = tmp;
                //如果当前比较的两个数需要交换，则交换后较小的数需要继续和前面的数比较
                for(int j = i; j > 0; j--) {
                    if(arr[j-1] > arr[j]) {
                        int tmp1 = arr[j];
                        arr[j] = arr[j-1];
                        arr[j-1] = tmp1;
                    }
                    else
                        break;
                }
            }
        }
        return arr;
    }

    /**
     * 选择排序
     * @param arr
     * @return
     */
    public static int[] selectSort(int[] arr) {
        if(arr.length <= 1)     return arr;
        for(int i = 0; i < arr.length-1; i++) {
            //每次循环固定最前面的一个数
            //每次循环都取第一个元素与后面所有元素比较，如果有比第一个元素小的就交换，
            //再用这个小的继续与后面的元素比较
            for(int j = i+1; j < arr.length; j++) {
                if(arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] a = {3,1,6,9,2,5,7};
        int[] arr = bubbleSort(a);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +"  ");
        }
        System.out.println("冒泡");

        int[] brr = insertSort(a);
        for(int i = 0; i < brr.length; i++) {
            System.out.print(brr[i] +"  ");
        }
        System.out.println("插入");

        int[] crr = selectSort(a);
        for(int i = 0; i < crr.length; i++) {
            System.out.print(crr[i] +"  ");
        }
        System.out.println("选择");
    }
}
