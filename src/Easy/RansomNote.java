package Easy;

public class RansomNote {
	public boolean canConstruct(String ransomNote, String magazine) {
        int len1 = ransomNote.length();
        int len2 = magazine.length();
        int[] a = new int[255];
        int[] b = new int[255];
        for(int i = 0; i < len1; i++) {
        	a[ransomNote.charAt(i)]++;
        }
        for(int j = 0; j < len2; j++) {
        	b[magazine.charAt(j)]++;
        }
        
		return false;
    }
}
