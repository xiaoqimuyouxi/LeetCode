package Easy;

public class PowerOf2 {

	//231题	2ms
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
	
	/*
	 * 用log时，唯独使用536870912的时候是false
	 * 改为用log10就对了	2ms
	 * Math.log()返回以自然对数e为底的数
	 * Math.log10()返回以10为底的数
	 */
	public static boolean isPowerof3san(int n){
		return Math.log10(n)/Math.log10(2) % 1 == 0;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerof3san(536870912));
	}
}
