package Easy2;

/**
 * 415题
 * 两个包含数字的字符串相加得到另一个只包含数字的字符串
 * Created by ly on 2016/10/21.
 */
public class AddStrings {
    //23ms
    public static String addStrings(String num1, String num2) {
        int carry = 0;
        int m = num1.length();
        int n = num2.length();
        int len = Math.max(m, n);
        char[] res = new char[len+1];
        for(int i = 0; i <= len; i++) {
            int a = i < m ? (num1.charAt(m-i-1) - '0'):0;
            int b = i < n ? (num2.charAt(n-i-1) - '0'):0;
            res[len-i] = (char)((a+b+carry)%10+'0');
            carry = (a+b+carry)/10;
        }
        return res[0] == '0' ? new String(res, 1, len) : new String(res, 0, len+1);
    }

    //30ms
    public static String addStrings1(String num1, String num2) {
        if(num1 == null && num2 == null)
            return null;
        StringBuilder res = new StringBuilder();
        int carry = 0;
        int m = num1.length()-1, n = num2.length()-1;
        while(m>=0 || n>=0) {
            int a = m >= 0 ? num1.charAt(m)-'0' : 0;
            int b = n >= 0 ? num2.charAt(n)-'0' : 0;
            int sum = a + b + carry;
            carry = sum > 9 ? 1 : 0;
            res.insert(0, sum%10);
            m--;
            n--;
        }
        if(carry == 1)
            res.insert(0, 1);
        return res.toString();
    }

    public static void main(String[] args) {
        int a = Character.digit('2', 10);
        System.out.println(a);
        char s = Character.forDigit(2, 10);
        System.out.println(s);
        System.out.println(addStrings1("9", "99"));
    }
}
