package Easy;

//9题 	回文数 	题目要求不能使用额外的存储容器Do this without extra space.
public class PalindromeNumber {

	//16ms
	public static boolean isPalindrome(int x) {
        String s = Integer.toString(x);
        int n = s.length();
        if(n == 1)
        	return true;
        int i = 0;
        while(i<n/2){
        	System.out.println("s.charAt(i):"+s.charAt(i));
        	System.out.println("s.charAt(n-1-i):"+s.charAt(n-1-i));
        	System.out.println(s.charAt(i) == s.charAt(n-1-i));
        	if(!(s.charAt(i) == s.charAt(n-1-i)))
        		return false;
        	else
        		i++;
        }
        if(i == n/2){
        	return true;
        }
    		
        return false;
    }
	
	//12ms 
	public static boolean isPalindrome2(int x) {
		int y = x;
		int a = 0;
		while(y>0){
			a = a*10 + y%10;
			y = y/10;
		}
		return x==a;
	}
	
	//23ms
	public static boolean isPalindrome3(int x) {
		StringBuilder sb = new StringBuilder(x+"");
		return sb.toString().equals(sb.reverse().toString());
	}
	
	public static void main(String[] args) {
		System.out.println(isPalindrome3(11011));
	}
}
