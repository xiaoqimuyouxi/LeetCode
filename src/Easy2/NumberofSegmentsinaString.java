package Easy2;

/**
 * 434题
 * 字符串中非空格片段的个数
 * Created by ly on 2016/12/9.
 */
public class NumberofSegmentsinaString {
    //4ms
    public int countSegments(String s) {
        s = s.trim();
        s = s.replaceAll("\\s+", " ");
        if(s == null || s.length() == 0)
            return 0;
        char[] arr = s.toCharArray();    //s.trim()去掉字符串首尾空格
        int count = 0;
        for(char c : arr) {
            if(c == ' ')
                count++;
        }
        return count+1;
    }

    //2ms
    public int countSegments1(String s) {
        int count = 0;
        for(int i = 0; i < s.length(); i++) {
            //前一个字符是空格后一个不是空格时，count才进行+1操作
            if(s.charAt(i)!=' ' && (i == 0 || s.charAt(i-1) == ' '))
                count++;
        }
        return count;
    }
    public static void main(String[] args) {
        NumberofSegmentsinaString n = new NumberofSegmentsinaString();
        System.out.println(n.countSegments1(" hello, world !  "));
    }
}
