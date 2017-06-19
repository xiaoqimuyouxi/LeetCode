package conclusion.offer;

/**
 * 调整数组顺序使奇数位于偶数前面
 *
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * Created by ly on 2017/6/19.
 */
public class P14ReOrderArray {

    //保证奇数与奇数，偶数与偶数之间相对位置不变的解法
    //可扩展性的解法即为，将第二三个while里的条件更改就行，同下面可扩展性解法
    public static void reOrderArray(int [] array) {
        if(array == null || array.length <= 1) {
            return;
        }

        int p1 = 0;
        int p2 = -1;
        while (p2 < array.length) {
            //向后移动p1，直到它为偶数
            while (array[p1] % 2 != 0) {
                p1++;
            }
            if(p2 < p1) {
                p2 = p1 + 1;
            }
            //向后移动P2，直到它指向奇数
            while (p2 < array.length && array[p2] % 2 == 0) {
                p2++;
            }
            if(p2 == array.length) {
                return;
            }
            int inter = p2 - p1;
            int pre = p2 - 1;
            int next = p2;
            //当碰到的第一个偶数与奇数之间存在多个偶数时
            while (inter > 0) {
                int tmp = array[pre];
                array[pre] = array[next];
                array[next] = tmp;

                pre--;
                next--;
                inter--;
            }
            p1++;
            p2++;
        }
    }

    public static void reOrderArray2(int [] array) {
        if(array.length <= 0 || array == null) {
            return;
        }

        int i = 0, j;
        while (i < array.length) {
            while (i < array.length && !isEven(array[i])) {
                i++;
            }
            j = i + 1;
            while (j < array.length && isEven(array[j])) {
                j++;
            }
            if(j < array.length) {
                int tmp = array[j];
                for (int k = j - 1; k >= i; k--) {
                    array[k+1] = array[k];
                }
                array[i++] = tmp;
            }
            else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] array = {1,3,5,7,2,4,6};
        reOrderArray2(array);
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + "   ");
        }
        System.out.println();
    }

    //不保证奇数与奇数，偶数与偶数之间相对位置不变的解法
    //采用头尾两个指针，头指针指向偶数，尾指针指向奇数时则交换两个数
    //但是该种解法不具备可扩展性，例如将所有负数都放在非负数前面，将能被3整除的放在不能被3整除的前面等
    public static void reOrderArray1(int[] array) {
        if(array == null || array.length == 0) {
            return;
        }

        int start = 0;
        int end = array.length-1;
        while (start < end) {
            //向后移动start，直到它指向偶数
            while (start < end && array[start]%2 != 0) {
                start++;
            }

            //向前移动end，直到它指向奇数
            while (start < end && array[end]%2 == 0) {
                end--;
            }

            if(start < end) {
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }
    }

    //不保证奇数与奇数，偶数与偶数之间相对位置不变的解法
    //可扩展性解法
    public static void reOrderArray1(int[] array, boolean func) {
        if(array == null || array.length == 0) {
            return;
        }

        int start = 0;
        int end = array.length-1;
        while (start < end) {
            while (start < end && !func) {
                start++;
            }
            while (start < end && func) {
                end--;
            }
            if (start < end) {
                int tmp = array[start];
                array[start] = array[end];
                array[end] = tmp;
            }
        }
    }

    public static boolean isEven(int n) {
        return (n & 1) == 0;
    }
}
