package Easy;

public class PowerOf2 {

	//231Ã‚	2ms
	public static boolean isPowerof2(int n){
		if(n <= 0)
			return false;
		while(n>0){
			if(n>1){
				if(n%2 != 0)
					return false;
				else{
					n /= 2;
				}
			}else if(n < 1){
				if(n*2 > 1)
					return false;
				else if(n*2 == 1)
					return true;
				else
					n = n*2;
			}
			else
				return true;
			if(n == 1)
				return true;
		}
		return false;
	}
	
	//2ms
	public static boolean isPowerof2er(int n){
		return n > 0 && (n&(n-1))==0;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerof2(536870912));
	}
}
