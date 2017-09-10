package exam;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by ly on 2017/9/2.
 */
public class CVTE {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        /*ArrayList<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int size = list.size();
        int x = 1;
        Iterator<Integer> it = list.iterator();
        while (size > 0) {
            if(!it.hasNext()) {
                it = list.iterator();
            }
            int k = it.next();
            if(x == m) {
                x = 1;
                size--;
                it.remove();
                System.out.print(k + " ");
            }
            else x++;
        }*/

        String ms = String.valueOf(m);
        int k = ms.length();
        int index = 1;
        String res = String.valueOf(n);
        int sum = Integer.parseInt(res.substring(0, k));
        for (int i = k; i < res.length(); i+=k) {
            char x = res.charAt(i);
            int xi = Integer.parseInt(String.valueOf(x));
            if(sum > m) {

            }
        }
    }
}
