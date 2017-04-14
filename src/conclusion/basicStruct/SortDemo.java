package conclusion.basicStruct;

import java.util.ArrayList;
import java.util.List;

/**
 * 几种排序算法总结
 *
 * 1、冒泡排序 bubbleSort
 * 2、插入排序 insertSort
 * 3、选择排序 selectSort
 * 4、快速排序 QuickSort
 * 5、希尔排序 shellSort
 * 6、归并排序，递归与迭代 MergeSort
 * 7、堆排序 heapSort
 *
 * Created by ly on 2016/12/20.
 */
@SuppressWarnings("ALL")
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
        //需要arr.length-1次循环，每一次循环找出当前循环中最大的数
        for(int i = 0; i < arr.length-1; i++) {
            //每次找到的最大的数沉到最末尾以后不再比较这个数
            for(int j = 0; j < arr.length-i-1; j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j, j+1);
                }
            }
        }
        return arr;
    }

    public static void bubbleSort1(int[] arr) {
        //需要arr.length-1次循环，每一次循环找出当前循环中最大的数
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
    }

    public static void bubbleSort2(List<Integer> arr) {
        arr.add(90);
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
//            if(arr[i] > arr[i+1]) {
//                int tmp = arr[i];
//                arr[i] = arr[i+1];
//                arr[i+1] = tmp;
                //如果当前比较的两个数需要交换，则交换后较小的数需要继续和前面的数比较
                for(int j = i+1; j > 0; j--) {  //j=i
                    if(arr[j-1] > arr[j]) {
                        swap(arr, j, j-1);
                    }
                    else
                        break;
                }
//            }
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
                    swap(arr, i, j);
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

    private static int[] QSort(int[] arr, int low, int high) {
        int mid;
        if(low < high) {
            mid = partition(arr, low, high);
            QSort(arr, low, mid-1);     //对低子表递归排序
            QSort(arr, mid+1, high);    //对高子表递归排序
        }
        return arr;
    }

    private static int partition(int[] arr, int low, int high) {
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

    /**
     * 希尔排序
     * @param arr
     * @return
     */
    public static int[] shellSort(int[] arr) {
        int i, j;
        int increment = 0;
        while (increment < arr.length/3) {
            increment = increment * 3 + 1;
        }
        for (; increment > 0; increment/=3) {
            for(i = increment; i < arr.length; i++) {
                int tmp = arr[i];
                for(j = i-increment; j >= 0 && tmp < arr[j]; j -= increment) {
                    arr[j+increment] = arr[j];
                }
                arr[j+increment] = tmp;
            }
        }

        return arr;
    }

    /**
     * 归并排序，递归解法
     * 时间复杂度O(nlogn)
     * @param arr
     * @return
     */
    public static int[] MergeSort(int[] arr) {
        if(arr.length <= 1) {
            return arr;
        }

        return MSort(arr, 0, arr.length-1);
    }

    private static int[] MSort(int[] arr, int start, int end) {
        if(arr.length <= 1) {
            return arr;
        }

        if(start >= end) {
            return arr;
        }
        int mid = (start + end)/2;
        int start2 = mid+1;
        MSort(arr, start, mid);
        MSort(arr, start2, end);

        //合并
        int[] tmp = new int[arr.length];
        int index = start;
        int temp = start;
        while (start <= mid && start2 <= end) {
            if(arr[start] <= arr[start2]) {
                tmp[index++] = arr[start++];
            }
            else {
                tmp[index++] = arr[start2++];
            }
        }
        while (start <= mid) {
            tmp[index++] = arr[start++];
        }
        while (start2 <= end) {
            tmp[index++] = arr[start2++];
        }

        for (int i = temp; i < end+1; i++) {
            arr[i] = tmp[i];
        }
        return arr;
    }

    /**
     * 归并排序，迭代解法
     */
    public static int[] mergeSort2(int[] arr) {
        if(arr.length <= 1) {
            return arr;
        }
        int window = 1;
        int[] tmp = new int[arr.length];
        for (; window < arr.length; window*=2) {
            for(int start = 0; start < arr.length; start += 2*window) {
                int start1 = start;
                int end1, end2;
                if(start1+window < arr.length) {
                    end1 = start1+window;
                }
                else {
                    end1 = arr.length;
                }
                int start2 = end1;
                if(start1+2*window < arr.length) {
                    end2 = start1+2*window;
                }
                else {
                    end2 = arr.length;
                }

                int index = start1;
                while (start1 < end1 && start2 < end2) {
                    if(arr[start1] < arr[start2]) {
                        tmp[index++] = arr[start1++];
                    }
                    else {
                        tmp[index++] = arr[start2++];
                    }
                }

                while (start1 < end1) {
                    tmp[index++] = arr[start1++];
                }
                while (start2 < end2) {
                    tmp[index++] = arr[start2++];
                }
                for(int i = start; i < end2; i++) {
                    arr[i] = tmp[i];
                }
            }
        }
        return arr;
    }

    /**
     * 堆排序
     *
     * 二叉堆的数组从下标1开始存储，而不是0，若当前节点为i，则左子节点为2i，右子节点为2i+1，父节点为i/2
     *
     * 思路：
     *     1、构建大顶堆maxHeap（下标从0开始，所以和二叉堆有细微差别，节点i的左子节点为2i+1）
     *     2、大顶堆的0位置元素显然是最大的，将这个数沉到数组最末端
     *     3、重复步骤1、2
     * @param arr
     * @return
     */
    public static int[] heapSort(int[] arr) {
        if(arr.length <= 1) {
            return arr;
        }

        for (int i = 0; i < arr.length; i++) {
            maxHeap(arr, arr.length-1-i);
            swap(arr, 0, arr.length-1-i);
        }
        return arr;
    }

    //构建大顶堆
    public static void maxHeap(int[] arr, int lastIndex) {
        for (int i = (lastIndex-1)/2; i >= 0; i--) {
            int k = i;  //保存当前正在判断节点的索引
            //如果当前节点存在子节点（判断依据是其左子节点索引在lastIndex范围内）
            while (2*k+1 <= lastIndex) {
                int biggerIndex = 2*k + 1;  //biggerIndex总是记录值较大的节点的索引，初始值为左子节点索引
                if(biggerIndex < lastIndex) {   //如果右子节点存在，否则biggerIndex=lastIndex
                    if(arr[biggerIndex] < arr[biggerIndex+1]) {
                        //如果右子节点比左子节点的值大，则biggerIndex记录的是右子节点的值
                        biggerIndex++;
                    }
                }
                if(arr[k] < arr[biggerIndex]) {
                    //如果当前节点值小于其所有子节点的值，那么交换，//将当前节点索引设置为biggerIndex
                    swap(arr, k, biggerIndex);
                    k = biggerIndex;
                }
                else
                    break;
            }
        }

    }

    public static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    public static void main(String[] args) {
        int[] a = {3,1,6,9,2,5,7};
        int[] arr = bubbleSort(a);
        for(int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] +"  ");
        }
        System.out.println("冒泡");

        int[] b = {3,1,6,9,2,5,7};
        int[] brr = insertSort(b);
        for(int i = 0; i < brr.length; i++) {
            System.out.print(brr[i] +"  ");
        }
        System.out.println("插入");

        int[] c = {3,1,6,9,2,5,7};
        int[] crr = selectSort(c);
        for(int i = 0; i < crr.length; i++) {
            System.out.print(crr[i] +"  ");
        }
        System.out.println("选择");

        int[] d = {3,1,6,9,2,5,7};
        int[] drr = QuickSort(d);
        for(int i = 0; i < drr.length; i++) {
            System.out.print(drr[i] +"  ");
        }
        System.out.println("快速");

        int[] e = {3,1,6,9,2,5,7};
        int[] err = shellSort(e);
        for(int i = 0; i < err.length; i++) {
            System.out.print(err[i] +"  ");
        }
        System.out.println("希尔");

        int[] f = {3,1,6,9,2,5,7};
        int[] frr = MergeSort(f);
        for(int i = 0; i < frr.length; i++) {
            System.out.print(frr[i] +"  ");
        }
        System.out.println("归并");


        int[] g = {3,1,6,9,2,5,7};
        int[] grr = mergeSort2(g);
        for(int i = 0; i < grr.length; i++) {
            System.out.print(grr[i] +"  ");
        }
        System.out.println("归并2");

        int[] h = {3,1,6,9,2,5,7};
        int[] hrr = heapSort(h);
        for (int i = 0; i < hrr.length; i++) {
            System.out.print(hrr[i] + "  ");
        }
        System.out.println("堆排序");

        int[] h1 = {3,1,6,9,2,5,7};
        bubbleSort1(h1);
        for (int i = 0; i < h1.length; i++) {
            System.out.print(h1[i] + "  ");
        }
        System.out.println("--------");

        ArrayList<Integer> a1 = new ArrayList<>();
        a1.add(3);
        a1.add(5);
        a1.add(1);
        a1.add(2);
        bubbleSort2(a1);
        System.out.println(a1.toString());
    }
}
