package Easy;

import java.util.Arrays;

//14题
public class LongestCommonPrefix {
	//5ms
	public static String longestCommonPrefix(String[] strs) {
		if(strs.length == 0)
			return "";
		StringBuilder sb = new StringBuilder(strs[0]);
		for(int i = 1; i < strs.length; i++){
			int end = Math.min(sb.length(), strs[i].length());
			sb.delete(end, strs[i].length());
			int j;
			for (j = 0; j < end; j++){
				if(strs[i].charAt(j) != sb.charAt(j))
					break;
			}
			sb.delete(j, sb.length());
		}
		return sb.toString();
    }
	
	//1ms
	public static String longestCommonPrefix2(String[] strs) {
		if(strs.length == 0 || strs == null)
			return "";
		String prefix = strs[0];
		for(int i = 0; i < strs.length; i++){
			if(prefix.equals(strs[i]))
				continue;
			int k = 0;
			while(k<prefix.length() && k<strs[i].length() && prefix.charAt(k)==strs[i].charAt(k))
				k++;
			prefix = prefix.substring(0, k);
		}
		return prefix;
	}
	
	//2ms
	public static String longestCommonPrefix3(String[] strs) {
		if(strs.length == 0 || strs == null)
			return "";
		StringBuilder result = new StringBuilder();
		Arrays.sort(strs); 		//对strs数组进行自然排序，得到第一个与最后一个是前缀相同元素最少的
		char[] a = strs[0].toCharArray();
		char[] b = strs[strs.length-1].toCharArray();
		for(int i = 0; i < a.length; i++){
			if(b.length>i && b[i] == a[i])
				result.append(b[i]);
			else
				return result.toString();
		}
		return result.toString();
	}
	
	public static void main(String[] args) {
		String[] strs = {"fegregtgtfsr", "fegrehgtrrfe", "fegrthgf","fehtghngn"};
		String[] str = {};
		System.out.println(longestCommonPrefix3(strs));
		System.out.println(longestCommonPrefix2(strs));
	}
}
