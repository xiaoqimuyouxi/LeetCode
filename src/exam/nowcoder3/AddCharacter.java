package exam.nowcoder3;

import java.util.Scanner;

/**
 * 添加字符
 * Created by ly on 2017/8/29.
 */
public class AddCharacter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String A = scanner.next();
        String B = scanner.next();
        if(B.contains(A)) {
            System.out.println(0);
            return;
        }

        int lenA = A.length();
        int lenB = B.length();
        int min = Integer.MAX_VALUE;
        for (int i = 0; i <= lenB-lenA; i++) {
            int index = 0;
            int count = 0;
            for (int j = i; j < i+lenA; j++) {
                if(A.charAt(index++) != B.charAt(j)) count++;
            }
            if(min > count) {
                min = count;
            }
        }
        System.out.println(min);
        /*String start = B.substring(0, lenB-lenA);
        String end = B.substring(lenA, lenB);
        String A1 = start + A;
        String A2 = A + end;
        int e1 = 0;
        int e2 = 0;
        for (int i = 0; i < lenB; i++) {
            if(A1.charAt(i) != B.charAt(i))
                e1++;
            if(A2.charAt(i) != B.charAt(i))
                e2++;
        }
        int res = e1 > e2 ? e2 : e1;
        System.out.println(res);*/
    }
}
