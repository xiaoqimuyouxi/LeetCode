package Easy2;

/**
 * 387题
 * 一个字符串中第一个唯一的字符
 * @author ly
 *
 */
public class FirstUniqueCharacterinaString {

	//20ms
	public static int firstUniqChar(String s) {
        int[] tmp = new int[26];
        for(char c : s.toCharArray()) {
        	tmp[c-'a']++;
        }
        int i;
        int minIndex = Integer.MAX_VALUE;
        for(i = 0; i < 26; i++) {
        	if(tmp[i] == 1 && minIndex > s.indexOf(""+(char)(i+'a')))
        		minIndex = s.indexOf(""+(char)(i+'a'));
        }
        if(i == 26 && minIndex == Integer.MAX_VALUE)
        	return -1;
        return minIndex;
    }
	
	//42ms
	public static int firstUniqChar1(String s) {
		for(int i = 0; i < s.length(); i++) {
			if(s.indexOf(s.charAt(i)) == s.lastIndexOf(s.charAt(i)))
				return i;
		}
		return -1;
	}
	
	public static void main(String[] args) {
		System.out.println(firstUniqChar1("leetcode"));
	}
}
