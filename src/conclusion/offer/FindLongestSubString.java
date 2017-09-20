package conclusion.offer;

import java.util.HashMap;

/**
 * 具体的思路是这样的：遍历整个字符串，针对每个字符做三件事

 （1）   如果当前字符出现过并且该字符上一次出现时的index大于目前子串的初始index，那么将目前子串的初始index置为该字符上一次出现时的index。注意这个子串不一定是最大长度的子串，而是程序运行过程中当前的不重复子串。

 （2）   如果当前的index与startIndex（目前子串的初始index）的差值大于maxLen（记录的最长不重复子串的长度），那么更新maxLen。注意，因为我们要输出这个不重复子串，所以我们在这时候（maxLen改变时）需要记录startIndex。

 （3）   记录当前字符的index。

 这样扫描完以后，我们就可以根据oriStartIndex（maxLen改变时记录的startIndex）和maxLen来得到最长不重复子串。

 具体实现如下，其中findLongestSubString1()函数是利用HashMap来实现的，而findLongestSubString2()函数是利用数组来实现的，两者的算法思想是一模一样的，但是性能相差近10倍。
 *
 * Created by ly on 2017/9/20.
 */
public class FindLongestSubString {
    public static String find1(String s) {
        if(s == null)   return null;
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        HashMap<Character, Integer> mapIndex = new HashMap<>();
        int startIndex = -1, oriStartIndex = startIndex, maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if(mapIndex.containsKey(arr[i])) {
                int oriIndex = mapIndex.get(arr[i]);
                if(oriIndex > startIndex) {
                    startIndex = oriIndex;
                }
            }
            if(i-startIndex > maxLen) {
                maxLen = i - startIndex;
                oriStartIndex = startIndex;
            }
            mapIndex.put(arr[i], i);
        }
        for (int i = oriStartIndex+1; i < oriStartIndex+maxLen+1; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(find2("abcdeac"));
    }

    public static String find2(String s) {
        if(s == null)   return null;
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        int[] charIndex = new int[256];
        for (int i = 0; i < 256; i++) {
            charIndex[i] = -1;
        }
        int startIndex = -1, oriStartIndex = startIndex, maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            if(charIndex[arr[i]] > startIndex) {
                startIndex = charIndex[arr[i]];
            }
            if(i-startIndex > maxLen) {
                maxLen = i - startIndex;
                oriStartIndex = startIndex;
            }
            charIndex[arr[i]] = i;
        }
        for (int i = oriStartIndex+1; i < oriStartIndex+maxLen+1; i++) {
            sb.append(arr[i]);
        }
        return sb.toString();
    }
}
