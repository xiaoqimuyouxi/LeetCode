package Easy;

import java.util.HashSet;
/**
 * 409��		���ַ����п�����ɵ��������ַ�������
 * 
 * @author ly
 *
 */
public class LongestPalindrome {

	//22ms
	/**
	 * ������ͬ�ַ����ж��ٶԣ�ÿһ�Զ����Թ��ɻ����ַ����е�Ԫ��
	 * �����󼯺��л���Ԫ�ؾͱ��������Է�����һ��Ԫ���ڻ����ַ������м�
	 * @param s
	 * @return
	 */
	public static int longestPalindrome(String s) {
		if(s==null || s.length()==0)
			return 0;
		HashSet<Character> hs = new HashSet<Character>();
		int count = 0;
		for(int i = 0; i < s.length(); i++) {
			if(hs.contains(s.charAt(i))) {
				hs.remove(s.charAt(i));
				count++;
			}
			else
				hs.add(s.charAt(i));
		}
		
		if(!hs.isEmpty())
			return count*2+1;
		return count*2;
	}
	
	//12ms
	public static int longestPalindrome2(String s) {
		if(s==null || s.length()==0)
			return 0;
		int length = 0;
		Boolean odd = new Boolean(false);
		int[] lower = new int[26];
		int[] upper = new int[26];
		for(int i = 0; i < 26; i++) {
			lower[i] = 0;
			upper[i] = 0;
		}
		
		for(int k = 0; k < s.length(); k++) {
			if(s.charAt(k) >= 97) {
				lower[s.charAt(k)-'a']++;
			}
			else
				upper[s.charAt(k)-'A']++;
		}
		
		for(int j = 0; j < 26; j++) {
			if(lower[j]%2 == 0)
				length += lower[j];
			else {
				odd = true;
				length += lower[j]/2*2;
			}
			
			if(upper[j]%2 == 0)
				length += upper[j];
			else {
				odd = true;
				length += upper[j]/2*2;
			}
		}
		if(odd) 
			return length+1;
		return length;
	}
	
	public static void main(String[] args) {
		System.out.println(longestPalindrome2("abccccdd"));
	}
}
