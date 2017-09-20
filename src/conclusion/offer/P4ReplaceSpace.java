package conclusion.offer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * Created by ly on 2017/9/20.
 */
public class P4ReplaceSpace {
    public static String replaceSpace(StringBuffer str) {
        if(str == null) {
            return null;
        }
        int len = str.length();
        int spaceNum = 0;
        int i = len-1;
        while (i >= 0) {
            if(str.charAt(i) == ' ') {
                spaceNum++;
            }
            i--;
        }
        for (int j = 0; j < spaceNum; j++) {
            str.append("  ");   //长度加两个空格，因为原来已经有一个空格
        }
        int newLen = str.length();
        int p1 = len -1;
        int p2 = newLen - 1;
        while (p1 >= 0 && p2 > p1) {
            if(str.charAt(p1) == ' ') {
                str.replace(p2, (p2--)+1, "0");
                str.replace(p2, (p2--)+1, "2");
                str.replace(p2, (p2--)+1, "%");
            }
            else {
                String s = ""+str.charAt(p1);
                str.replace(p2, (p2--)+1, s);
            }
            p1--;
        }
        return str.toString();
    }

    public static void main(String[] args) {
        StringBuffer sb = new StringBuffer("We are happy!");
        System.out.println(replaceSpace(sb));
    }
}
