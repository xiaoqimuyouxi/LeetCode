package conclusion.offer;

/**
 * Created by ly on 2017/9/16.
 */
public class P49StrToInt {
    public int strToInt(String str) {
        if(str == null || str.length() <= 0) {
            return 0;
        }
        boolean isNegative = false;
        char first = str.charAt(0);
        int i = 0;
        if(first < '0') {
            if(first == '-') {
                isNegative = true;
            }
            else if(first != '+') {
                return 0;
            }

            if(str.length() == 1) {
                return 0;
            }
            i++;
        }

        int num = 0;
        for(; i < str.length(); i++) {
            char c = str.charAt(i);
            if(c >= '0' && c <= '9') {
                num = num*10 + c-48;
                if((isNegative && num < Integer.MIN_VALUE) || (!isNegative && num > Integer.MAX_VALUE)) {
                    return 0;
                }
            }
            else return 0;
        }
        return isNegative ? -num : num;
    }
}
