package Easy;

/**
 * 389��
 * ����s����ĳ�����λ������һ���ַ��õ�t���ҳ������ӵ��ַ�
 * @author ly
 *
 */
public class FindDifference {

	//6ms	ֱ�Ӽ���������ַ����ֱ��ܵ��ַ���Ӧ������ֵ��������õ����ӵ��ַ�
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
	
	//5ms	���ñ���֮�����ķ���
	public static char findTheDifference2(String s, String t) {
		char[] c1 = s.toCharArray();
        char[] c2 = t.toCharArray();
        char c = 0;
        for(char b : c1) 
        	c ^= b;
        for(char a : c2)
        	c ^= a;
        return (char)c;
	}
	
	public static void main(String[] args) {
		System.out.println(findTheDifference2("abcd", "decba"));
	}
}
