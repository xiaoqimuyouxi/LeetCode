package conclusion.offer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by ly on 2017/9/5.
 */
public class AtoI {
    public static int StrToInt(String str) {
        boolean isNegative = false; //是否为负数
        if(str == null || str.length() == 0) {
            return 0;
        }
        char c = str.charAt(0);
        int i = 0;
        if(c == '-') {
            i++;
            isNegative = true;  //负数
        }
        else if(c == '+') {
            i++;
        }
        int num = 0;
        for (; i < str.length(); i++) {
            c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                num = num*10 + c-48;
                if((isNegative && -num < Integer.MIN_VALUE) || (!isNegative && num > Integer.MAX_VALUE)) {
                    return 0;
                }
            }
            else {
                return 0;
            }
        }
        return isNegative ? -num : num;
    }

    public static void main(String[] args) {
        System.out.println(StrToInt("-25532"));
    }
}
