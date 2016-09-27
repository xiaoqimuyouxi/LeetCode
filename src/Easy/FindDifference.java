package Easy;

/**
 * 389题
 * 重排s并在某个随机位置增加一个字符得到t，找出这个添加的字符
 * @author ly
 *
 */
public class FindDifference {

	//6ms	直接计算出两个字符串分别总的字符对应的整数值，相减即得到增加的字符
	public static char findTheDifference(String s, String t) {
        char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        int re1 = 0;
        int re2 = 0;
        for(int i = 0; i < c1.length; i++) {
        	re1 += c1[i];
        }
        
        for(int j = 0; j < c2.length; j++) {
        	re2 += c2[j];
        }
        return (char)(re2-re1);
    }
	
	public static void main(String[] args) {
		System.out.println(findTheDifference("abcd", "decba"));
	}
}
