package Easy2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 438题
 * 查找字符串中所有另一字符串颠倒顺序的索引
 * Created by ly on 2016/12/12.
 */
public class FindAllAnagramsinaString {
    //38ms
    /**
     * anagrams，就是只顺序不同但个数相同的字符串，那我们就可以利用hashtable的思想来比较每个字符串中字符出现的个数是否相等。
     对于两个字符串我们分别准备数组(大小为256)来存储每个字符出现的次数：
     1) 对于p，我们遍历，并在hp中记录字符出现的次数；
     2) 之后遍历s,先把当前字符的个数+1，但是需要考虑当前index是否已经超过了p的长度，如果超过，则表示前面的字符已经不予考虑，
     所以要将index-plen的字符的个数-1；最后判断两个数组是否相等，如果相等，返回index-plen+1,即为开始的下标。
     * @param s
     * @param p
     * @return
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int m = p.length(), n = s.length();
        int[] a = new int[26];
        int[] b = new int[26];
        for(char ps : p.toCharArray()) {
            a[ps - 'a']++;
        }

        for(int i = 0;  i < n; i++) {
            char ss = s.charAt(i);
            b[ss - 'a']++;

            if(i >= m) {
                b[s.charAt(i-m)-'a']--;
            }
            if(Arrays.equals(a, b))
                ans.add(i-m+1);
        }
        return ans;
    }

    //23ms
    public List<Integer> findAnagrams1(String s, String p) {
        List<Integer> result = new ArrayList<>();
        int[] arr = new int[26];
        for(char ps : p.toCharArray()) {
            arr[ps - 'a']++;
        }
        int start = 0, end = 0, count = p.length();
        while(end < s.length()) {
            // If the char at start appeared in p, we increase count
            if(end-start == p.length() && arr[s.charAt(start++) - 'a']++ >= 0)
                count++;
            // If the char at end appeared in p (since it's not -1 after decreasing), we decrease count
            if(--arr[s.charAt(end++) - 'a'] >= 0)
                count--;
            if(count == 0)
                result.add(start);
        }
        return result;
    }

    public static void main(String[] args) {
        FindAllAnagramsinaString f = new FindAllAnagramsinaString();
        System.out.println(f.findAnagrams1("bnaa", "aa"));
    }
}
