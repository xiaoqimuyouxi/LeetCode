package Easy3;

/**
 * 67题  将两个字符串表示的二进制相加得到另一个字符串表示的二进制
 * Created by ly on 2016/12/29.
 */
public class AddBinary {
    //4ms
    public String addBinary(String a, String b) {
        int as = a.length();
        int bs = b.length();
        if(as == 0) return b;
        if(bs == 0) return a;
        char[] ac = a.toCharArray();
        char[] bc = b.toCharArray();
        StringBuilder res = new StringBuilder();
        int i = as-1, j = bs-1;
        int count = 0;  //进位
        for (; i > -1 && j > -1 ; i--, j--) {
            int tmp = (ac[i]-'0') + (bc[j]-'0') + count;
            if(tmp == 3) {
                res.append(1);
                count = 1;
            }
            else if (tmp == 2) {
                res.append(0);
                count = 1;
            }
            else if(tmp == 1) {
                res.append(1);
                count = 0;
            }
            else {
                res.append(0);
                count = 0;
            }
        }
        while(j > -1) {
            if(count == 1) {
                if(bc[j] == '1') {
                    res.append(0);
                    count = 1;
                    j--;
                }
                else {
                    res.append(1);
                    count = 0;
                    j--;
                }
            }
            else {
                res.append(bc[j--]);
                count = 0;
            }
        }

        while(i > -1) {
            if(count == 1) {
                if(ac[i] == '1') {
                    res.append(0);
                    count = 1;
                    i--;
                }
                else {
                    res.append(1);
                    count = 0;
                    i--;
                }
            }
            else {
                res.append(ac[i--]);
                count = 0;
            }
        }

        if(count == 1) {
            res.append(1);
        }

        return res.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary ab = new AddBinary();
        System.out.println(ab.addBinary("11010101", "101010101"));
    }
}
