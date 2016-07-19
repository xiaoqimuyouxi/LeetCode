package Easy;

import java.util.ArrayList;
import java.util.List;

//345Ã‚
public class ReverseVowels {
	//28ms
	 public static String reverseVowels(String s) {
		char[] c = new char[]{'a','o','e','i','u','A','O','E','I','U'};
		int[] a = new int[256];
		StringBuilder result = new StringBuilder();
        List<Character> list = new ArrayList<Character>();
        for(int i = 0; i < s.length(); i++){
        	for(int j = 0; j < c.length; j++){
        		if(s.charAt(i) == c[j]){
        			a[s.charAt(i)-'\0'] = s.charAt(i);
        		}
        	}
        	if(a[s.charAt(i)-'\0'] != 0){
        		list.add(s.charAt(i));
        	}
        }
        int index = list.size()-1;
        for(int i = 0; i < s.length(); i++){
        	if(a[s.charAt(i)-'\0'] != 0){
        		result.append(list.get(index--));
        	}else
        		result.append(s.charAt(i));
        }
        return result.toString();
	 }
	 
	 //17ms
	 public static String reverseVowels2(String s) {
		 String vowels = "aoeiuAOEIU";
		 char[] c = s.toCharArray();
		 int first = 0;
		 int last = s.length()-1;
		 while(first < last){
			 while(first < last && !vowels.contains(c[first]+""))
				 first++;
			 while(first<last && !vowels.contains(c[last]+""))
				 last--;
			 
			 char temp = c[first];
			 c[first] = c[last];
			 c[last] = temp;
			 first++;
			 last--;
		 }
		 return new String(c);
		 
	 }
	 
	 public static void main(String[] args) {
		System.out.println(reverseVowels2("leetcode"));
	}
}
