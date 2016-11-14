package Easy2;

/**
 * 171题
 * 根据给定EXCEL表的列名获取到它的列号
 * Created by ly on 2016/11/14.
 */
public class ExcelSheetColumnNumber {
    //3ms
    public int titleToNumber(String s) {
        char[] c = s.toCharArray();
        int len = c.length;
        int res = 0;
        for(int i = len-1; i >= 0; i--) {
            int inf = 1;
            int count = len-1-i;
            while(count > 0) {
                inf *= 26;
                count--;
            }
            res += inf*(c[i]-'A'+1);
        }
        return res;
    }

    //2ms
    public int titleToNumber1(String s) {
        //这里result=0所以循环第一次不会乘26
        int result = 0;
        for(int i = 0; i < s.length(); i++) {
            result *= 26;
            result += (s.charAt(i)-'A')+1;
        }
        return result;
    }

    public static void main(String[] args) {
        ExcelSheetColumnNumber n = new ExcelSheetColumnNumber();
        int a = n.titleToNumber1("AAA");
        System.out.println(a);
    }
}
