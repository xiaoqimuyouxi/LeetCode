package Easy;
//http://www.cnblogs.com/graphics/archive/2010/06/21/1752421.html�㷨
public class NumberOf1Bits {

	//191��
	public static int hammingWeight(int n){
		int c = 0;
		while(n != 0){	//n������2147483647(100000000000000000000000000000000) 
			//javaĬ�����з��ŵģ��������������n!=0
			if((n&1)==1)
				++c;
			n>>>=1;	//һ����λ��n>>=1,����λ���������������޷��ŵ�λ��������n>>>=1
		}
		return c;
	}
	
	public static void main(String[] args) {
		System.out.println(hammingWeight(2147483647));
	}

}
