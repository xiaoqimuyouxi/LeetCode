package conclusion.offer;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序找出这两个只出现一次的数字。
 * Created by ly on 2017/9/1.
 */
public class P40FindOnceNum {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        if(array == null || array.length <= 1) {
            return;
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result ^= array[i];
        }
        int index = findFirst1(result);
        for (int i = 0; i < array.length; i++) {
            if(is1(array[i], index)) {
                num1[0] ^= array[i];
            }
            else
                num2[0] ^= array[i];
        }
    }
    public int findFirst1(int result) {
        int index = 0;
        while ((result & 1) == 0 && index < 32) {
            result = result >> 1;
            index++;
        }
        return index;
    }
    //判断数 num 的第index 位是否为 1
    public boolean is1(int num, int index) {
        /*while (index > 0) {
            num = num >> 1;
            index--;
        }
        if((num&1) == 0) {
            return false;
        }
        return true;*/
        num = num >> index;
        return (num&1) == 0 ? false : true;
    }

    //输入一组未排序的整数，其中一个数字只出现一次，剩下的所有数字都出现了三次。找出这个只出现一次的数字。例如输入: [1,2,2,2,3,3,3]，输出为1
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] array = new int[n];
        int[] temp = new int[32];
        for (int i = 0; i < n; i++) {
           array[i] = scanner.nextInt();
            int index = 0;
            int k = array[i];
            while (k > 0 && index < 32) {
                if((k&1) == 1) {
                    temp[index]++;
                }
                index++;
                k = k >> 1;
            }
        }
        int x = 0;
        for (int i = 0; i < 32; i++) {
            int k = temp[i]%3;
            if(k != 0) {
                x += k*Math.pow(2, i);
            }
        }
        System.out.println(x);
        /*Arrays.sort(array);
        int count = 1;
        int temp = array[0];
        for (int i = 1; i < n; i++) {
            if(array[i] == temp) {
                count++;
            }
            else {
                if(count == 1) {
                    System.out.println(temp);
                    return;
                }
                count = 1;
                temp = array[i];
            }
        }*/

    }
    //数字a中1的个数
    public static int numOf1Bit(int a) {
        int num = 0;
        while (a > 0) {
            a = a&(a-1);
            num++;
        }
        return num;
    }
}
