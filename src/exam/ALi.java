package exam;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ly on 2017/3/2.
 */
public class ALi {
    /** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static boolean resolve(int[] A) {
        if(A.length <= 6 || A == null) {
            return false;
        }

        int start = 0;
        int end = A.length-1;
        int tmpSum = 0;
        int x = 0;
        while (start < end) {
            if(A[start] < A[end]) {
                tmpSum = A[end];
                x += A[start++];
            }
        }

        int m1 = 1;
        int m2 = 3;
        int m3 = 5;
        int x1 = A[0], x2 = A[2], x3 = A[4], x4 = A[6];
        while (m3 < A.length-1) {
            if(x1 == x2 && x2 == x3 && x3 == x4) {
                return true;
            }
            while(x1 < x2) {

            }
        }

        return false;
    }

    public static void main(String[] args){
        ArrayList<Integer> inputs = new ArrayList<Integer>();
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();
        while(line != null && !line.isEmpty()) {
            int value = Integer.parseInt(line.trim());
            if(value == 0) break;
            inputs.add(value);
            line = in.nextLine();
        }
        int[] A = new int[inputs.size()];
        for(int i=0; i<inputs.size(); i++) {
            A[i] = inputs.get(i).intValue();
        }
        Boolean res = resolve(A);

        System.out.println(String.valueOf(res));
    }
}
