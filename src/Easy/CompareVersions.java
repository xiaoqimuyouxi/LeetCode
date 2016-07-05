package Easy;
public class CompareVersions {

	public static int compareVersion(String version1, String version2) {
		String[] v1 = version1.split("\\.");
		String[] v2 = version2.split("\\.");
		StringBuilder s1 = new StringBuilder();
		StringBuilder s2 = new StringBuilder();
		if(v1.length > v2.length){
			
			for(int j = 0; j < v1.length-v2.length; j++ ){
				s1.append(v1[v2.length+j]);
			}
		}
		else if(v1.length < v2.length){
			for(int j = 0; j < v2.length-v1.length; j++ ){
				s2.append(v2[v1.length+j]);
			}
		}
		int b = 2;
		if (v1.length != 0 || v2.length != 0) {
			for(int i = 0; i < Math.min(v1.length, v2.length); i++){
				if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])){
					b = 1;
					return b;
				}
					
				else if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])){
					b = -1;
					return b;
				}
				else
					b = 0;
			}
			if(b == 0){
				if(v1.length > v2.length){
					if(Integer.parseInt(s1.toString()) == 0){
						b = 0;
						return b;
					}else{
						b = 1;
						return b;
					}
					
				}
				else if(v1.length < v2.length){
					if(Integer.parseInt(s2.toString()) == 0){
						b = 0;
						return b;
					}else{
						b = -1;
						return b;
					}
				}
				else
					b = 0;
			}
		}
		return b;

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String ver1 = "1.0";
		String ver2 = "1.0.0";
		int a = compareVersion(ver1, ver2);
		if(a == 1){
			System.out.println("version1 > version2: "+ver1 +" > "+ver2);
		}
		else if(a == -1){
			System.out.println("version1 < version2: "+ver1 +" < "+ver2);
		}
		else if(a ==0){
			System.out.println("version1 = version2: "+ver1 +" = "+ver2);
		}
		else
			System.out.println("version1 Óë version2Îª¿Õ£¡£¡");
		
	}

}
