package Easy;

public class RomanToInt {

	/**
	 * 9ms，13题
	 */
	public static int romanToInt(String s){
		int sum = 0;
		int i = 0;
		while(i < s.length()){
			
			if(s.charAt(i) == 'I'){
				//如果不加限制，当i=length-1时，要先和length里面的值比较，会越界
				if(i+1 < s.length()){
					if(s.charAt(i+1) == 'V'){
						sum += 4;
						i += 2;
					}else if(s.charAt(i+1) == 'X'){
						sum += 9;
						i += 2;
					}else{
						sum += 1;
						i += 1;
					}
				}else{
					sum += 1;
					i += 1;
				}
			}else if(s.charAt(i) == 'X'){
				if(i+1 < s.length()){
					if(s.charAt(i+1) == 'L'){
						sum += 40;
						i += 2;
					}else if(s.charAt(i+1) == 'C'){
						sum += 90;
						i += 2;
					}else{
						sum += 10;
						i += 1;
					}
				}else{
					sum += 10;
					i += 1;
				}
				
			}else if(s.charAt(i) == 'C'){
				if(i+1 < s.length()){
					if(s.charAt(i+1) == 'D'){
						sum += 400;
						i += 2;
					}else if(s.charAt(i+1) == 'M'){
						sum += 900;
						i += 2;
					}else{
						sum += 100;
						i += 1;
					}
				}else{
					sum += 100;
					i += 1;
				}
				
			}else{
				if(s.charAt(i) == 'V'){
					sum += 5;
					i += 1;
				}else if(s.charAt(i) == 'L'){
					sum += 50;
					i += 1;
				}else if(s.charAt(i) == 'D'){
					sum += 500;
					i += 1;
				}else if(s.charAt(i) == 'M'){
					sum += 1000;
					i += 1;
				}
			}
		}
		return sum;
	}
	
	public static void main(String[] args) {
		System.out.println(romanToInt("DCXXI"));
	}

}
