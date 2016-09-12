package Easy;

/**
 * 223题		矩形面积
 * @author ly
 *
 */
public class RectangleArea {

	//4ms
	public static int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area1, area2;
        area1 = (C-A)*(D-B);
        area2 = (G-E)*(H-F);
        
        if(A>=G || C<=E || B>=H || D<=F)
        	return area1+area2;
        
        int length = Math.min(G, C) - Math.max(A, E);
        int high = Math.min(H, D) - Math.max(F, B);
        
        return area1+area2-length*high;
    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println(computeArea(-3,0,3,4,0,-1,9,2));
	}

}
