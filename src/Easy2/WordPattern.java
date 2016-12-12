package Easy2;

import java.util.HashMap;

/**
 * 290题
 * 判断字符串是否符合指定模型
 * Created by ly on 2016/12/12.
 */
public class WordPattern {
    //2ms
    public boolean wordPattern(String pattern, String str) {
        if(pattern.length() == 0 || str.length() == 0)
            return false;

        String[] sarr = str.split(" ");
        if(sarr.length != pattern.length())
            return false;
        HashMap<String, Character> map1 = new HashMap<>();
        HashMap<Character, String> map2 = new HashMap<>();
        for(int i = 0; i < sarr.length; i++) {
            String s = sarr[i];
            char c = pattern.charAt(i);
            if(map1.containsKey(s)) {
                if(map1.get(s) != c)
                    return false;
            }
            if(map2.containsKey(c)) {
                if(!map2.get(c).equals(s))  //两个字符串的比较不能直接用!=，这里使用equals比较
                    return false;
            }
            map1.put(s, c);
            map2.put(c, s);
        }
        return true;
    }

    public static void main(String[] args) {
        WordPattern w = new WordPattern();
        System.out.println(w.wordPattern("aaaa", "dog cat cat dog"));
    }
}
