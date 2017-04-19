package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 输入:
 n,s1,p1, s2, p2, …, sn, pn m 输入划分2行。第一行 n 表示为优惠档次，s表示纸巾包数，p表示单价。 其中 0=s1 < s2< … < sn ≤ 100 , 1000 ≥ p1 ≥ p2 ≥ … ≥ pn ≥ 0 ，数字之间是半角的逗号分割。直到输入换行符为止。 第二行m是计划至少买纸巾包数，换行符结束。
 输出:
 2,0,13,100,10 99 表示2档优惠。在购买少于100包纸巾时，单价为13元；购买100包及以上，单价为10元。
 输入范例:
 购买满足最低要求数量的纸巾数需要的花费。
 输出范例:
 输出1000
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
