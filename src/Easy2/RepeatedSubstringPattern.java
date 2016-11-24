package Easy2;

/**
 * 459题     给定字符串是否由重复的子字符串组成
 * Created by ly on 2016/11/19.
 */
public class RepeatedSubstringPattern {
    //O(n^2)    58ms
    public boolean repeatedSubstringPattern(String str) {
        if(str.length() < 2)
            return false;
        int i = 1;
        boolean flag = false;
        //取字符串长度的一半
        while(i <= str.length()/2) {
            //找出可行的子字符串长度i
            if(str.length()%i == 0) {
                flag = check(str, i);
            }
            i++;
            if(flag)
                break;
        }
        return flag;
    }

    public boolean check(String str, int distance) {
        for(int i = distance; i < str.length(); i+=distance) {
            for(int j = 0; j < distance; j++) {
                if(str.charAt(i+j) != str.charAt(j))
                    return false;
            }
        }
        return true;
    }

    //错的。。。。。。。。
    public boolean repeatedSubstringPattern1(String str) {
        if(str.length() < 2)
            return false;
        int len = str.length();
        char[] arr = str.toCharArray();
        boolean flag = false;
        int low = 0;
        int fast = 1;
        while(fast < len) {
            if(arr[fast] == arr[0]) {
                for(low = 0; fast < len;) {
                    if(arr[low] == arr[fast]) {
                        flag = true;
                        low++;
                        fast++;
                    }
                    else {
                        flag = false;
                        break;
                    }
                }
            }
            else {
                fast++;
                flag = false;
            }
        }
        return flag && low*2>=len;
    }

    public static void main(String[] args) {
        RepeatedSubstringPattern r = new RepeatedSubstringPattern();
        boolean flag = r.repeatedSubstringPattern1("aabaaba");
        System.out.println(flag);
    }
}
