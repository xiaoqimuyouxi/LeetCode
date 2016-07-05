package Easy;

/*
 * 设有a=3,b=6
 * a=0011, b =0110
 * 所以不进位和是5 =0101，进位为2 =0010
 * 所以a+b就变成了5+2<<1
 * 
 * 然后有5 =0101， 2<<1 =0100
 * 不进位和是1 =0001， 进位是4 =0100
 * 所以a+b变成1+4<<1
 * 
 * 然后有1 =0001， 4<<1 =1000
 * 不进位和是9 =1001， 进位是0 =0000
 * 
 */

public class SumOf2Integers {
	
	public static int getSum(int a, int b){
		int nCarry = a&b;	//进位
		int nSumnoCarry = a^b;	//非进位
		if(nCarry != 0)
			return getSum(nCarry<<1, nSumnoCarry);
		else
			return nSumnoCarry;
	}
	
	public static void main(String[] args) {
		System.out.println(getSum(25, 2568916));
	}

}
