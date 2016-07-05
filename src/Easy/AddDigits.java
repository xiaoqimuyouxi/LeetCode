package Easy;

public class AddDigits {

	public static int addDigits(int num){
		int c = num;
		int sum = 0;
		boolean isOne = false;
		while(!isOne){
			while(c/10 != 0){
				sum+=(c%10);
				c = c/10;
			}
			sum += c;
			if(sum/10 ==0){
				isOne = true;
			}
			else{
				c = sum;
				sum = 0;
			}
		}
		
		return sum;
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int num = 25;
		System.out.println(addDigits(num));
	}

}
