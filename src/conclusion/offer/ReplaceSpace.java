package conclusion.offer;

/**
 * 请实现一个函数，将一个字符串中的空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为We%20Are%20Happy。
 * Created by ly on 2017/5/5.
 */
public class ReplaceSpace {
    //用两个指针，一个指向字符串末尾，一个指向替换之后字符串的末尾，从后往前遍历
    //时间复杂度是O(n)
    public static String replaceSpace(StringBuffer str) {
        int length = str.length();
        int spaceNum = 0;
        int i = 0;
        while (i < length) {
            if(str.charAt(i) == ' ') {
                spaceNum++;
            }
            i++;
        }
        for (int j = 0; j < spaceNum; j++) {
            str.append("  ");   //长度加两个空格
        }
        int newLength = str.length();
        int p1 = length-1;
        int p2 = newLength-1;
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

    static void Test(StringBuffer str, String expected) {
        if(replaceSpace(str).equals(expected)) {
            System.out.println("Succeed!");
        }
        else {
            System.out.println("Failed!");
        }
    }

    public static void main(String[] args) {
        StringBuffer str = new StringBuffer("Are you happy?");
        Test(str, "Are%20you%20happy?");
    }
}
