package Easy;

import java.util.ArrayList;

/**
 * 383题		勒索信、赎价笔记
 * 字符串2中是否包含字符串1中的所有字符
 * @author ly
 *
 */
public class RansomNote {
	/**
	 * 17ms	空间换取时间
	 * 空间复杂度为O(n)
	 * 时间复杂度为O(n)
	 * 255的空间改成26，a[ransomNote.charAt(i)]改成a[ransomNote.charAt(i) - 'a']，其余类似
	 * 可以减小空间浪费，但是时间差不多
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public static boolean canConstruct(String ransomNote, String magazine) {
        int len1 = ransomNote.length();
        int len2 = magazine.length();
        int[] a = new int[255];
        int[] b = new int[255];
        for(int i = 0; i < len1; i++) {
        	a[ransomNote.charAt(i)]++;
        }
        for(int j = 0; j < len2; j++) {
        	b[magazine.charAt(j)]++;
        }
        
        for(int k = 0; k < len1; k++) {
        	if(a[ransomNote.charAt(k)] > b[ransomNote.charAt(k)]) 
        		return false;
        }
        
		return true;
    }
	
	//63ms
	public static boolean canConstruct1(String ransomNote, String magazine) {
		int rLength = ransomNote.length();
		int mLength = magazine.length();
		if(rLength > mLength) 
			return false;
		ArrayList<Character> list = new ArrayList<Character>();
		for(int j = 0; j < mLength; j++) {
			list.add(magazine.charAt(j));
		}
		for(int i = 0; i < rLength; i++) {
			char temp = ransomNote.charAt(i);
			if(temp < 'a' || temp > 'z') 
				return false;
			if(list.contains(temp)) {
				list.remove((Object)temp);	//如果不转型成Object则会删除temp这个索引处的值
			}
			else
				return false;
		}
		return true;
	}
	
	/**
	 * 别人改进	14ms
	 * 如果觉得128的空间造成了过多的多余，可以用26替换
	 * 相应的下面temp[c-'a']替换掉temp[c]
	 * @param ransomNote
	 * @param magazine
	 * @return
	 */
	public static boolean canConstruct2(String ransomNote, String magazine) {
		int[] temp = new int[128];	
		for(char c : magazine.toCharArray())
			temp[c]++;
		
		for(char c : ransomNote.toCharArray()) {
			if(temp[c]-- <= 0) 
				return false;
		}
		return true;
	}
	
	public static void main(String[] args) {
		System.out.println(canConstruct2("ab", "aab"));
	}
}
