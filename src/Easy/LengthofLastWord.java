package Easy;

//58��	���һ�����ʳ���
public class LengthofLastWord {

	//13ms
	//û����������ʽʱһֱ����Line 8: java.lang.ArrayIndexOutOfBoundsException: -1
	//���������ַ�������Ϊ����ո���Ʊ�����з���
	public static int lengthOfLastWord(String s) {
		if(s.matches("\\W+") || s == "") {	//������ʽ��ʾһ�������ǵ����ַ�
			return 0;
		}
		else {
		    String[] str = s.split(" ");
            String word = str[str.length-1];
            return word.length();
		}
    }
	
	//11ms
	public static int lengthOfLastWord2(String s) {
		String[] ss = s.split(" ");
		if(ss.length == 0) {	//ת�����ַ�����������ж�
			return 0;
		}
		String word = ss[ss.length-1];
		return word.length();
	}
	
	//7ms
	public static int lengthOfLastWord3(String s) {
		s = s.trim();
		int last = s.lastIndexOf(" ");
		return s.length() - 1 - last;
	}
	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord3("hello world   "));
	}
}
