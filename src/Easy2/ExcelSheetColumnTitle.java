package Easy2;

/**
 * 168题
 * 给定excel表的列数获取到该列的列名
 * Created by ly on 2016/11/14.
 */
public class ExcelSheetColumnTitle {
    //0ms
    public String convertToTitle(int n) {
        if(n <= 0)
            return null;
        StringBuilder res = new StringBuilder();
        while(n > 0) {
            char s;
            //在Z这里经常出问题！！
            if(n%26 == 0) {
                s = 'Z';
                //采用n--可以避免问题发生
                n--;
            }
            else
                s = (char)(65+(n%26-1));
            res.append(s);
            //整除
            n /= 26;
        }
        return res.reverse().toString();
    }
    public static void main(String[] args) {
        ExcelSheetColumnTitle e = new ExcelSheetColumnTitle();
        String s = e.convertToTitle(702);
        System.out.println(s);
    }
}
