package Easy;

//38Ìâ
public class CountAndSay {

	//23ms
	public static String countAndSay(int n) {
        if(n <= 0)
        	return null;
        String s = "1";
        int i = 1;
        while(i < n) {
        	String temp = "";
        	for(int j = 0; j < s.length(); j++) {
        		int count = 1;
        		while(j+1<s.length() && s.charAt(j) == s.charAt(j+1)) {
        			j++;
        			count++;
        		}
        		temp += count + s.substring(j, j+1);
        	}
        	s = temp;
        	i++;
        }
        return s;
    }
	
	//19ms
	public static String countAndSay2(int n) {
		if(n <= 0)
			return null;
		if(n == 1)
			return "1";
		String s = "";
		String kid = countAndSay2(n-1);
		int left = 0, right = 0;
		while(left < kid.length()) {
			while(right < kid.length() && kid.charAt(left) == kid.charAt(right))
				right++;
			s+= (right - left) + kid.substring(left, left+1);
			left = right;
		}
		return s;
	}
	
	//2ms
	public static String countAndSay3(int n) {
		String str = "1";
		for(int i = 0; i < n-1; i++) {
			str = calculate(str);
		}
		return str;
	}
	
	public static String calculate(String str) {
		int n = str.length();
		int count = 1;
		StringBuilder sb = new StringBuilder();
		for(int j = 0; j < n; j++) {
			if(j+1 < n && str.charAt(j) == str.charAt(j+1)) {
				count++;
			}else {
				sb.append(count);
				sb.append(str.charAt(j));
				count = 1;
			}
		}
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println(countAndSay3(3));
		System.out.println(countAndSay3(4));
	}
}
