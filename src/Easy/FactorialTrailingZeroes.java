package Easy;

//http://www.purplemath.com/modules/factzero.htm

//ÕÒ¹æÂÉ£¡£¡
public class FactorialTrailingZeroes {

	//172Ìâ	2ms
	public static int trailingZeroes(int n) {
		int count = 0;
		while(n!=0){
			count += n/5;
			n = n/5;
		}
		return count;
    }
	
	public static void main(String[] args) {
		System.out.println(trailingZeroes(25));
	}
}
