package Easy;

import java.util.HashMap;

/**
 * 205题		同构字符串
 * @author ly
 *
 */
public class IsomorphicStrings {

	//13ms
	public static boolean isIsomorphic(String s, String t) {
        
		if(s.length() != t.length())
			return false;
		
		int[] s1 = new int[255];
		int[] t1 = new int[255];
 		
		for(int i = 0; i < s.length(); i++) {
			int tmp1 = (s1[s.charAt(i)]);
			int tmp2 = (t1[t.charAt(i)]);
			if(tmp1 != tmp2)
				return false;
			s1[s.charAt(i)] = i+1;
			t1[t.charAt(i)] = i+1;
		}
		
		return true;
    }
	
	//用两个HashMap来实现		49ms
	public static boolean isIsomorphic2(String s, String t) {
		if(s.length() != t.length()) {
			return false;
		}
		
		HashMap<Character, Character> map1 = new HashMap<Character, Character>();
		HashMap<Character, Character> map2 = new HashMap<Character, Character>();
		
		for(int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			char b = t.charAt(i);
			if(map1.containsKey(a)) {
				if(map1.get(a) != b)
					return false;
			}
			if(map2.containsKey(b)) {
				if(map2.get(b) != a)
					return false;
			}
			
			map1.put(a, b);
			map2.put(b, a);
		}
		return true;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(isIsomorphic2("aba", "baa"));
	}

}
