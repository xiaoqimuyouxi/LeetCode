package Easy;

import java.util.ArrayList;
import java.util.List;

/*
 * ��Ŀ��˼�ǳ���happy���������������ѭ�����ɣ���ִ������ѭ����ĳ����ʱ��ִ�к�ǰ����ͬ��ѭ��
 */
public class HappyNumber {

	//202��  7ms
	public static boolean isHappy(int n){
		if(n <= 0)
			return false;
		List<Integer> list = new ArrayList<Integer>();
		list.clear();
		int sum = 0;
		while(n>1){
			while(n/10 != 0){
				sum += ((n%10)*(n%10));
				n = n/10;
			}
			sum += (n*n);
			
			for(int i = 0; i < list.size(); i++){
				if(((Integer)sum).equals(list.get(i)))
					return false;
			}
			list.add(sum);
			if(sum == 1)
				return true;
			else{
					n = sum;
					sum = 0;
			}
		}
		
		if(n == 1)
			return true;
		else
			return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isHappy(2));
	}

}
