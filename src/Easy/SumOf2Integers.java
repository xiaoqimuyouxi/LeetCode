package Easy;

/*
 * ����a=3,b=6
 * a=0011, b =0110
 * ���Բ���λ����5 =0101����λΪ2 =0010
 * ����a+b�ͱ����5+2<<1
 * 
 * Ȼ����5 =0101�� 2<<1 =0100
 * ����λ����1 =0001�� ��λ��4 =0100
 * ����a+b���1+4<<1
 * 
 * Ȼ����1 =0001�� 4<<1 =1000
 * ����λ����9 =1001�� ��λ��0 =0000
 * 
 */

public class SumOf2Integers {
	
	public static int getSum(int a, int b){
		int nCarry = a&b;	//��λ
		int nSumnoCarry = a^b;	//�ǽ�λ
		if(nCarry != 0)
			return getSum(nCarry<<1, nSumnoCarry);
		else
			return nSumnoCarry;
	}
	
	public static void main(String[] args) {
		System.out.println(getSum(25, 2568916));
	}

}
