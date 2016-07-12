package Easy;

import java.util.ArrayList;
import java.util.List;

/*
 * 题目意思是除了happy数外的其他数都有循环规律，当执行这种循环到某个数时会执行和前面相同的循环
 */
public class HappyNumber {

	//202题  7ms
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
