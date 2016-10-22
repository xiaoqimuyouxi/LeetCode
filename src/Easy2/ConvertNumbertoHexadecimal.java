package Easy2;

/**
 * Created by ly on 2016/10/22.
 */
public class ConvertNumbertoHexadecimal {
    //int用31位计算，最高位是符号位
    //没有跑出来。。。。一直有错误！
    public static String toHex(int num) {
        if(num == 0)
            return "0";
        String[] temp = {"a", "b", "c", "d", "e", "f"};
        StringBuilder res = new StringBuilder();
        boolean sign = false;
        if(num < 0) {
            //2^31=2147483648
            num = num+2147483647+1;
            sign = true;
        }
        while(num > 0) {
            int t = num%16;
            if(t>9) {
                res.insert(0, temp[t-10]);
            }
            else
                res.insert(0, t);
            num = num /16;
        }
        if(sign == true)
            return res.replace(0, 1, temp[res.charAt(0)-'0'+8-10]).toString();
        return res.toString();
    }

    public static String toHex1(int num) {
        char[] res = new char[8];
        int com = 0x0000000f;
        int index = 7;
        for(int i = 0; i < 8 && !(i != 0 && num == 0); i++) {
            int code = num & com;
            res[index--] = (char)((code>9?'a'-10:'0')+code);
            num >>>= 4;
        }
        return new String(res, index+1, 7-index);
    }

    //9ms
    public static String toHex2(int num) {
        char[] ret = new char[8];
        int mask = 0x0000000f, index = 7;
        for(int i = 0; i < 8 && !(i != 0 && num == 0); i++){
            int code = num & mask;
            ret[index--] = (char) ((code > 9? 'a' - 10: '0') + code) ;
            num >>>= 4;
        }
        return new String(ret, index + 1, 7 - index);
    }

    //7ms
    public static String toHex3(int num) {
        char[] res = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder r = new StringBuilder();
        if(num == 0)
            return "0";
        while(num != 0) {
            r.insert(0, res[num&0xf]);
            num >>>= 4;
        }
        return r.toString();
    }

    public static void main(String[] args) {
        System.out.println(toHex3(26));
    }
}
