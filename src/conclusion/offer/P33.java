package conclusion.offer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;

/**
 * Created by ly on 2017/8/14.
 */
public class P33 {
    ArrayList<String> list = new ArrayList<>();
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length <= 0) {
            return "";
        }
        for (int i = 0; i < numbers.length; i++) {
            String s = String.valueOf(numbers[i]);
            list.add(s);
        }

        //重写比较器，定义新的字符串大小判断标准
        Collections.sort(list, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                /*boolean isEqual = false;
                int min = Math.min(o1.length(), o2.length());
                for (int i = 0; i < min; i++) {
                    int a = Integer.parseInt(String.valueOf(o1.charAt(i)));
                    int b = Integer.parseInt(String.valueOf(o2.charAt(i)));
                    if(a > b) {
                        return 1;
                    }
                    else if(a < b) {
                        return -1;
                    }
                    if(i == min-1) {
                        isEqual = true;
                    }
                }
                if(isEqual) {
                    if(o1.length() > o2.length()){
                        return -1;
                    }
                    else if(o1.length() == o2.length()){
                        return 0;
                    }
                    else return 1;
                }
                return 0;*/
                String str1 = o1+o2;
                String str2 = o2+o1;
                return str1.compareTo(str2);
            }
        });

        StringBuilder res = new StringBuilder();
        for(String s : list) {
            res.append(s);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        P33 p = new P33();
        int[] ar = {3334,3,3333332};
        System.out.println(p.PrintMinNumber(ar));
    }
}
