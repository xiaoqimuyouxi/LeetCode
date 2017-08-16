package exam.nowcoderHuaWei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * Created by ly on 2017/8/16.
 */
public class characterSet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            String str = scanner.next();
            if(str.trim().length() == 0 || str == null) {
                return;
            }

            str = str.trim();
            Set<Character> set = new HashSet<>();
            for (int i = 0; i < str.length(); i++) {
                char c = str.charAt(i);
                if(!set.contains(c)) {
                    System.out.print(c);
                    set.add(c);
                }
            }
            System.out.println();
        }
    }
}
