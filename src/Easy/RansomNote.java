package Easy;

import java.util.ArrayList;

/**
 * 383��		�����š���۱ʼ�
 * �ַ���2���Ƿ�����ַ���1�е������ַ�
 * @author ly
 *
 */
public class RansomNote {
	/**
	 * 17ms	�ռ任ȡʱ��
	 * �ռ临�Ӷ�ΪO(n)
	 * ʱ�临�Ӷ�ΪO(n)
	 * 255�Ŀռ�ĳ�26��a[ransomNote.charAt(i)]�ĳ�a[ransomNote.charAt(i) - 'a']����������
	 * ���Լ�С�ռ��˷ѣ�����ʱ����
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
				list.remove((Object)temp);	//�����ת�ͳ�Object���ɾ��temp�����������ֵ
			}
			else
				return false;
		}
		return true;
	}
	
	/**
	 * ���˸Ľ�	14ms
	 * �������128�Ŀռ�����˹���Ķ��࣬������26�滻
	 * ��Ӧ������temp[c-'a']�滻��temp[c]
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
