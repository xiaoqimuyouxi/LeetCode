package Easy;

public class ReverseString {

	//344Ìâ
	public static String reverseString(String s){
		StringBuilder sr = new StringBuilder();
		sr.append(s);
		return sr.reverse().toString();
		/*
		 * char[] c = s.toCharArray();
		for(int j = c.length-1; j>=0; j--){
			sr.append(c[j]);
		}
		return sr.toString();
		 */
		
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "hello world";
		String reverse = reverseString(s);
		System.out.println("reverse: "+reverse);
	}

}
