package Easy;
//http://www.cnblogs.com/graphics/archive/2010/06/21/1752421.html算法
public class NumberOf1Bits {

	//191题
	public static int hammingWeight(int n){
		int c = 0;
		while(n != 0){	//n可能是2147483647(100000000000000000000000000000000) 
			//java默认是有符号的，所以这里必须是n!=0
			if((n&1)==1)
				++c;
			n>>>=1;	//一般移位是n>>=1,符号位不动，而这里是无符号的位移所以是n>>>=1
		}
		return c;
	}
	
	public static void main(String[] args) {
		System.out.println(hammingWeight(2147483647));
	}

}
