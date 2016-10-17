package Easy;

import java.util.ArrayList;
import java.util.List;

/**
 * 3��5�ı���
 * @author ly
 *
 */
public class FizzBuzz {
	//4ms
	public static List<String> fizzBuzz(int n) {
        List<String> list = new ArrayList<String>();
        for(int i = 1; i <= n; i++) {
        	if(i % 3 == 0 && i % 5 == 0)
        		list.add("FizzBuzz");
        	else if(i%3==0)
        		list.add("Fizz");
        	else if(i%5==0)
        		list.add("Buzz");
        	else
        		list.add(""+i);
        }
        return list;
    }
	
	public static void main(String[] args) {
		System.out.println(fizzBuzz(15));
	}
}
