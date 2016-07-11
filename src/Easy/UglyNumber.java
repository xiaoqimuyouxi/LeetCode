package Easy;

import java.util.HashSet;
import java.util.Set;

public class UglyNumber {

	//263Ã‚ ≥¨ ±
	public static boolean isUgly(int num){
		if(num == 1)
			return true;
		else if(num <= 0)
			return false;
		int n = num;
		int i = 2;
		Set<Integer> priSet = new HashSet<Integer>();
		while(n >= i){
			if(n%i == 0){
				priSet.add(i);
				n = n/i;
			}
			else
				i++;
		}
		if(n != 1){
			priSet.add(n);
		}
		int size = priSet.size();
		if(size == 1){
			if(priSet.contains(2) ||priSet.contains(3) ||priSet.contains(5))
				return true;
			else
				return false;
		}else if(size == 2){
			if((priSet.contains(2)&&(priSet.contains(3)||priSet.contains(5))) ||(priSet.contains(3)
					&&priSet.contains(5)))
				return true;
			else
				return false;
		}else if(size == 3){
			if(priSet.contains(2)&&priSet.contains(3)&&priSet.contains(5))
				return true;
			else
				return false;
		}else
			return false;
			
	}
	
	//2ms
	public static boolean isUgly2(int num){
		int n = num;
		if(num <= 0){
			return false;
		}
		
		while(n%2==0)	n /=2;
		while(n%3==0)	n /=3;
		while(n%5==0)	n /=5;
		if(n == 1)	return true;
		else	return false;
	}
	
	public static void main(String[] args) {
		System.out.println(isUgly2(905391974));
	}

}
