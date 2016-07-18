package Easy;

public class BullsCows {

	//299题	3ms
	//主要是countB的计算，用一个数组将secret的值作为索引，出现但在当前位置与guess不等的次数作为值
	public static String getHint(String secret, String guess) {
        if(secret.length() != guess.length())
        	return "0A0B";
        int countA = 0;	//计算A的个数		bulls
        int countB = 0; //计算B的个数		cows
        char[] se = secret.toCharArray();
        char[] gu = guess.toCharArray();
        int[] a = new int[256];
        for(int i = 0; i < secret.length(); i++){
        	if(se[i] == gu[i]){
        		countA++;
        	}else{
        		int b = se[i]-'\0';
        		a[b]++;
        	}
        }
        for(int j = 0; j < secret.length(); j++){
        	int c = gu[j]-'\0';
        	if(a[c] > 0 && se[j]!=gu[j]){
        		countB++;
        		a[c]--;
        	}
        		
        }
        return countA+"A"+countB+"B";
    }
	
	public static void main(String[] args) {
		System.out.println(getHint("1","0"));
	}
}
