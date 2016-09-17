package Easy;

//58题	最后一个单词长度
public class LengthofLastWord {

	//13ms
	//没有用正则表达式时一直报错Line 8: java.lang.ArrayIndexOutOfBoundsException: -1
	//后来发现字符串可能为多个空格或制表符换行符等
	public static int lengthOfLastWord(String s) {
		if(s.matches("\\W+") || s == "") {	//正则表达式表示一个或多个非单词字符
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
