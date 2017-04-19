package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * Created by ly on 2017/4/19.
 */
public class ALi2 {

/*请完成下面这个函数，实现题目要求的功能*/
/*当然，你也可以不按照下面这个模板来作答，完全按照自己的想法来 ^-^ */
    /******************************开始写代码******************************/
    public  static int  minCost (String promotion,String  queryCost){
        String[] s = promotion.split(",");
        int n = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length-1;) {  //注意越界问题
            if(i == 0) {
                n = Integer.parseInt(s[i]);
                i++;
            }
            else {
                map.put(Integer.parseInt(s[i]), Integer.parseInt(s[i+1]));
                i+=2;
            }
        }
        int m = Integer.parseInt(queryCost);
        int q = 0;  //代表确认要买的数量
        int[] temp = new int[n];
        int index = 0;
        for(int k : map.keySet()) {
            temp[index++] = k;
        }
        //从后往前遍历阈值，找到最接近m但的大于m的数字即为所要找的阈值
        for (int i = temp.length-1; i >= 0; i--) {
            if(m < temp[i]) {
                if(i == temp.length-1) {
                    q = temp[i];
                }
                else {
                    q = temp[i+1];
                }
            }
        }
        return  q*map.get(q);
    }

    /******************************结束写代码******************************/


    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String  promotion = in.nextLine().trim();
        String  queryCost = in.nextLine().trim();

        int result =  minCost (promotion,queryCost);
        System.out.println(result);

    }
}
