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
	
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("        "));
	}
}
