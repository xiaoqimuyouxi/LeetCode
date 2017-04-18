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
//		System.out.println(numberOf1(2147483648));
	}

	//上面的解法如果n是负数的时候容易造成死循环
	//所以提出下面这种解法，每次将1左移后再与n进行比较
	//输入是2147483648则不可以
	public static int numberOf1(int n) {
		int count = 0;
		int i = 1;	//java中不区分有符号与无符号，但正数左移不影响正负
		while (i > 0) {
			if((n&i) > 0) {
				count++;
			}
			i = i << 1;	//i左移一位
			System.out.println(i);
		}
		return count;
	}
}
