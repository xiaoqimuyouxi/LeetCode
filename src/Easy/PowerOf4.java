package Easy;

public class PowerOf4 {

	//342Ã‚
	public static boolean isPowerOf4(int num){
		if(num <= 0)
			return false;
		while(num > 0){
			if(num > 1){
				if(num%4 != 0)
					return false;
				else
					num /= 4;
			}else if(num < 1){
				if(num*4 == 1)
					return true;
				else if(num*4 > 1)
					return false;
				else
					num = (num*4);
			}else
				return true;
			if(num == 1)
				return true;
		}
		return false;
	}
	
	/*
	 * By the logarithmic logic, log 4 (num) has to be an integer.
	 *  %1 is used to check if the result is an integer.
	 *  2ms
	 */
	public static boolean isPowerOf4er(int num){
		return (Math.log(num)/Math.log(4) %1 == 0);
	}
	
	public static boolean isPowerOf4san(int num){
		return num > 0 && (num&(num-1))==0 && (num & 0xAAAAAAAA)==0;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerOf4san(1));
	}

}
