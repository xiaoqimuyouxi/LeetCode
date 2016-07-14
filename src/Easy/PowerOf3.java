package Easy;

public class PowerOf3 {

	//326��	17ms!!
	public static boolean isPowerof3(int n){
		if(n <= 0)
			return false;
		while(n>0){
			if(n>1){
				if(n%3 != 0)
					return false;
				else{
					n /= 3;
				}
			}else if(n < 1){
				if(n*3 > 1)
					return false;
				else if(n*3 == 1)
					return true;
				else
					n = n*3;
			}
			else
				return true;
			if(n == 1)
				return true;
		}
		return false;
	}
	
	//18ms
	public static boolean isPowerof3er(int n){
		if(n <= 0)
			return false;
		if(n == 1)
			return true;
		while(n>1){
			if(n%3 != 0)
				return false;
			else{
				n /= 3;
			}
			if(n == 1)
				return true;
		}
		return false;
	}
	
	/*
	 * ��logʱ��Ψ��ʹ��243��ʱ����false
	 * ��Ϊ��log10�Ͷ���	19ms
	 * Math.log()��������Ȼ����eΪ�׵���
	 * Math.log10()������10Ϊ�׵���
	 */
	public static boolean isPowerof3san(int n){
		return Math.log10(n)/Math.log10(3) % 1 == 0;
	}
	
	public static void main(String[] args) {
		System.out.println(isPowerof3san(729));
	}
}
