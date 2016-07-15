package Easy;

public class PlusOne {
	
	//66Ìâ	2ms
	public static int[] plusOne(int[] digits){
		int c = 1;	//½øÎ»
		int[] result = new int[digits.length];
		for(int i = digits.length-1; i>=0; i--){
			int val = digits[i]+c;
			result[i] = val%10;
			c = val/10;
		}
		if(c == 1){
			result = new int[digits.length+1];
			result[0] = 1;
		}
		return result;
	}
	
	public static void main(String[] args) {
		int[] a = new int[]{};
		int[] b = new int[]{1};
		int[] c = new int[]{3,9};
		int[] d = new int[]{9,9};
		
		for(int i = 0; i < plusOne(a).length; i++){
			System.out.print(plusOne(a)[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < plusOne(b).length; i++){
			System.out.print(plusOne(b)[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < plusOne(c).length; i++){
			System.out.print(plusOne(c)[i] + " ");
		}
		System.out.println();
		
		for(int i = 0; i < plusOne(d).length; i++){
			System.out.print(plusOne(d)[i] + " ");
		}
		System.out.println();
	}
}
