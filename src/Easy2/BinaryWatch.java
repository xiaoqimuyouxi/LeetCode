package Easy2;

import java.util.ArrayList;
import java.util.List;

/**
 * 401题
 * 二进制手表
 * @author ly
 *
 */
public class BinaryWatch {
	//4ms
	public static List<String> readBinaryWatch(int num) {
        List<String> list = new ArrayList<String>();
        for(int h = 0; h < 12; h++) {
        	for(int m = 0; m < 60; m++) {
        		//Integer.bitCount(i);计算i的二进制表示中1的个数
        		if(Integer.bitCount(h) + Integer.bitCount(m) == num) {
        			if(m >= 0 && m < 10)
        				list.add(""+h+":0"+m);
        			else
            			list.add(""+h+":" +m);
        			//这里可用System.format("%d:%02d",h,m);表示
        		}
        	}
        }
        return list;
    }
	
	//4ms
	public static List<String> readBinaryWatch1(int num) {
		String[][] h = {
				{"0"},
				{"1", "2", "4", "8"},
				{"3", "5", "6",  "9", "10"},
				{"7", "11"}
		};
		String[][] m = {
				{"00"},
				{"01", "02", "04", "08", "16", "32"},
				{"03", "05", "06", "09", "10", "12", "17", "18", "20", "24", "33", "34", "36", "40","48"},
				{"07", "11", "13", "14", "19", "21", "22", "25", "26", "28", "35", "37", "38", "41", "42", "44",  "49", "50", "52", "56"},
				{"15", "23", "27", "29", "30", "39", "43", "45", "46", "51", "53", "54", "57", "58"},
				{"31", "47", "55", "59"}
		};
		
		List<String> list = new ArrayList<String>();
		for(int i = 0; i <= 3 && i <= num; i++) {
			if(num-i <= 5) {
				for(String r1 : h[i]) {
					for(String r2 : m[num-i])
						list.add(r1 + ":" + r2);
				}
			}
		}
		return list;
	}
	
	public static void main(String[] args) {
		System.out.println(readBinaryWatch1(1));
	}
}
