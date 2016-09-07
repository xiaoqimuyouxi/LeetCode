package Easy;

import java.util.ArrayList;
import java.util.List;

//118��	������ǡ���˹��������
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
        	//֮ǰ������ѭ�����棬����totalNum������ӵ�ȫ��tmpList���ã�ÿ�ζ��Ḳ��֮ǰ��ֵ
        	//�����Ƶ�ѭ����������ÿ��newһ����ͬ��������ӽ�ȥ�Ͳ��Ḳ����
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
        		tmpListPre.addAll(tmpList);		//���ʹ��add������tmpList��ֵ��Ϊ����
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
        	totalNum.add(tmpList);          //ÿ�����tmpList���Ḳ��֮ǰ��ֵ�����뵽��������tmpList��������
        									//���Ա�����������ͬ�Ķ������洢
        }
        return totalNum;
    }
	
	public static void main(String[] args) {
		System.out.println(generate(10));
	}
}
