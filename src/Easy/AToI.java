package Easy;

//8Ìâ	×Ö·û´®×ª»»Îªint
public class AToI {
	//48ms
	public static int myAtoi(String str) {
        int INT_MAX = 2147483647;
        int INT_MIN = -2147483648;
        str = str.trim();
        if(str==null || str.length() == 0) {
        	return 0;
        }
        int res = 0;
        int sign = 0;	//ÏÔÊ¾·ûºÅ
        int index = 0;
        boolean isNegative = false;
        for(; index < str.length() && sign < 2; index++) {
        	char ch = str.charAt(index);
        	int val = ch - 48;
        	
        	if(ch == '+' || ch == '-') {
        		sign++;
        		if(ch == '-') {
        			isNegative = true;
        		}
        		continue;
        	}
        	
        	if(val > 9 || val < 0) {
        		break;
        	}
        	if(!isNegative && res > (INT_MAX - val)/10) {
        		return INT_MAX;
        	}
        	if(isNegative && res > (INT_MAX - val)/10) {
        		return INT_MIN;
        	}
        	
        	res = res*10 + val;
        }
        
        if(isNegative) {
        	return res*-1;
        }
        return res;
    }
	
	public static void main(String[] args) {
		System.out.println(myAtoi("  -0012a42"));
	}
}
