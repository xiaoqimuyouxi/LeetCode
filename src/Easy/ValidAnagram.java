package Easy;

/**
 * 242Ìâ
 * ÏàÍ¬×ÖÄ¸ÒìĞò´Ê
 * @author ly
 *
 */
public class ValidAnagram {

	//4ms
	public static boolean isAnagram(String s, String t) {
        int[] as = new int[26];
        int[] at = new int[26];
        for(char c : s.toCharArray()) {
        	as[c-'a']++;
        }
        for(char c : t.toCharArray()) {
        	at[c-'a']++;
        }
        
        for(int i = 0; i < 26; i++) {
        	if(as[i] != at[i])
        		return false;
        }
        return true;
    }
	
	public static void main(String[] args) {
		System.out.println(isAnagram("anagram", "nagaram"));
	}
}
