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
     * 时间复杂度O(n^2)
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

    /**
     * 快速排序
     * 利用递归的思想
     * 平均时间复杂度O(nlogn)，最差时间复杂度O(n^2)
     * @param arr
     * @return
     */
    public static int[] QuickSort(int[] arr) {
        return QSort(arr, 0, arr.length-1);
    }

    public static int[] QSort(int[] arr, int low, int high) {
        int mid;
        if(low < high) {
            mid = partition(arr, low, high);
            QSort(arr, low, mid-1);     //对低子表递归排序
            QSort(arr, mid+1, high);    //对高子表递归排序
        }
        return arr;
    }

    public static int partition(int[] arr, int low, int high) {
        int pivotkey = arr[low];    //用子表的第一个值作为枢轴值
        while (low < high) {    //从表的两端交替向中间扫描
            while (low < high && arr[high] >= pivotkey)
                high--;
            int tmp = arr[low]; //将比枢轴小的数据交换到低端
            arr[low] = arr[high];
            arr[high] = tmp;
            while (low < high && arr[low] <= pivotkey)
                low++;
            int tmp1 = arr[low];    //将比枢轴大的数据交换到高端
            arr[low] = arr[high];
            arr[high] = tmp1;
        }
        return low;     //返回枢轴所在位置
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

        int[] drr = selectSort(a);
        for(int i = 0; i < drr.length; i++) {
            System.out.print(drr[i] +"  ");
        }
        System.out.println("快速");
    }
}
