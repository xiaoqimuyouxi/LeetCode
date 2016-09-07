package Easy;

import java.util.ArrayList;
import java.util.List;

//118题	杨辉三角、帕斯卡三角形
public class PascalTriangle {

	//1ms
	public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>>  totalNum = new ArrayList<List<Integer>>();
        List<Integer> tmpList1 = new ArrayList<Integer>();
        List<Integer> tmpListPre = new ArrayList<Integer>();
        
        if(numRows == 1) {
        	tmpList1.add(1);
        	totalNum.add(tmpList1);
        	return totalNum;
        }
        
        for(int i = 1; i <= numRows; i++) {
        	//之前定义在循环外面，导致totalNum里面添加的全是tmpList引用，每次都会覆盖之前的值
        	//现在移到循环里面来，每次new一个不同的引用添加进去就不会覆盖了
            List<Integer> tmpList = new ArrayList<Integer>();    
        	tmpList.clear();
        	if(i%2 == 0) {
        		tmpList.add(1);
        		for(int j = 0; j < i/2-1; j++) {
        			tmpList.add(tmpListPre.get(j)+tmpListPre.get(j+1));
        		}
        		for(int j = i/2-1; j >= 0; j--) {
        			tmpList.add(tmpList.get(j));
        		}
        		tmpListPre.clear();
        		tmpListPre.addAll(tmpList);		//如果使用add方法，tmpList的值就为空了
        	}
        	else {
        		tmpList.add(1);
        		for(int j = 0; j < (i-1)/2; j++) {
        			tmpList.add(tmpListPre.get(j)+tmpListPre.get(j+1));
        		}
        		for(int j = (i-1)/2-1; j >=0 ; j--) {
        			tmpList.add(tmpList.get(j));
        		}
        		tmpListPre.clear();
        		tmpListPre.addAll(tmpList);
        	}
        	totalNum.add(tmpList);          //每次添加tmpList都会覆盖之前的值，加入到容器的是tmpList对象引用
        									//所以必须用两个不同的对象来存储
        	//totalNum.add(new ArrayList<Integer>(tmpList));也是一种可行的解决方法
        }
        return totalNum;
    }
	
	//别人写的方法
	public static List<List<Integer>> generate2(int numRows)
	{
		List<List<Integer>> allrows = new ArrayList<List<Integer>>();
		ArrayList<Integer> row = new ArrayList<Integer>();
		for(int i=0;i<numRows;i++)
		{
			row.add(0, 1);
			for(int j=1;j<row.size()-1;j++)
				row.set(j, row.get(j)+row.get(j+1));
			allrows.add(new ArrayList<Integer>(row));	//每次new一个新的List引用，保证后面的值不会覆盖前面的
		}
		return allrows;
	}
	
	public static void main(String[] args) {
		System.out.println(generate2(10));
	}
}
