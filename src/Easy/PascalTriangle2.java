package Easy;

import java.util.ArrayList;
import java.util.List;

//119Ìâ		Ñî»ÔÈý½Ç2
public class PascalTriangle2 {

	//3ms
	public static List<Integer> getRow(int rowIndex) {
        List<Integer> row = new ArrayList<Integer>();
        for(int i = 0; i <= rowIndex; i++) {
        	row.add(0, 1);
        	for(int j = 1; j < row.size()-1; j++)
        		row.set(j, row.get(j)+row.get(j+1));
        }
        return new ArrayList<Integer>(row);
    }
	
	public static void main(String[] args) {
		System.out.println(getRow(1));
	}
}
