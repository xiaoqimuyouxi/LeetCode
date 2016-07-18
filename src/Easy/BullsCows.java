package Easy;

public class BullsCows {

	//299��	3ms
	//��Ҫ��countB�ļ��㣬��һ�����齫secret��ֵ��Ϊ���������ֵ��ڵ�ǰλ����guess���ȵĴ�����Ϊֵ
	public static String getHint(String secret, String guess) {
        if(secret.length() != guess.length())
        	return "0A0B";
        int countA = 0;	//����A�ĸ���		bulls
        int countB = 0; //����B�ĸ���		cows
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
