package conclusion.offer;

/**
 * Created by ly on 2017/9/17.
 */
public class QuickSort {
    public static void quicksort(int[] arr, int begin, int last) {
        if(arr == null || arr.length <= 1 || begin > last) {
            return;
        }

        int low = begin;
        int high = last;
        if(begin < last) {
            int mid = partion(arr, low, high);
            quicksort(arr, begin, mid - 1);
            quicksort(arr, mid + 1, last);
        }
    }

    public static int partion(int[] arr, int begin, int last) {
        if(arr == null || begin > last || arr.length <= 0) {
            return -1;
        }
        int key = arr[begin];
        while (begin < last) {
            while (begin < last && arr[last] >= key)
                last--;
            swap(arr, begin, last);
            while (begin < last && arr[begin] <= key)
                begin++;
            swap(arr, begin, last);
        }
        return begin;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2};
        quicksort(arr, 0, 2);
    }

    public static void swap(int[] arr, int low, int high) {
        int tmp = arr[low];
        arr[low] = arr[high];
        arr[high] = tmp;
    }
}
