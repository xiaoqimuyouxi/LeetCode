package exam.DJ;

import java.util.*;

/**
 * Created by ly on 2017/8/30.
 */
public class WorkingTime {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        int[] mapMonthDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};  //这个映射用来表示每个月有多少天
        HashMap<String, ArrayList<String[]>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            String[] s = scanner.nextLine().split(" ");
            String date = s[0];
            String[] date2 = date.split("\\."); //. 号在单独使用时代表匹配任意字符，所以必须加转义字符"\"
            String time = s[1];
            String[] time1 = time.split(":");
            String hh = time1[0];
            int h = change(hh);
            if(h >= 0 && h <= 2) {
                h = h+24;   //凌晨两点换成26点的表示
                int date1 = change(date2[1]);
                int date3 = change(date2[0]);   //月份
                String x;
                int k = date1 - 1;
                if(k < 10 && k > 0) {
                    x = "" + 0 + k;
                }
                else if(k == 0) {
                    if(date3 == 1) {

                    }
                    continue;
                }
                else {
                    x = "" + k;
                }
                date = date2[0] + "." + x;    //新的日期
//                time = h+":"+time1[1]+":"+time1[2]; //新的时间
                time1[0] = ""+h;
            }
            h = change(time1[0]);
            int m = change(time1[1]);
            if(h >= 12 && h < 14) {  //中间的休息时间
                if(!(h == 12 && m >= 30)) {
                    time1[0] = ""+12;
                    time1[1] = ""+29;
                    time1[2] = ""+59;
                }
            }
            if(map.containsKey(date)) {
                map.get(date).add(time1);
            }
            else {
                ArrayList<String[]> list = new ArrayList<>();
                list.add(time1);
                map.put(date, list);
            }
        }
        HashMap<String, Integer> map2 = new HashMap<>();
        for (String date : map.keySet()) {
            ArrayList<String[]> list = map.get(date);
            Collections.sort(list, new Comparator<String[]>() {
                @Override
                public int compare(String[] o1, String[] o2) {
                    if(o1[0].equals(o2[0])) {
                        if(o1[1].equals(o2[1])) {
                            return change(o1[2]) - change(o2[2]);
                        }
                        else {
                            return change(o1[1]) - change(o2[1]);
                        }
                    }
                    else return change(o1[0]) - change(o2[0]);
                }
            });
            if(list.size() < 2) {
                map2.put(date, -1);
                continue;
            }
            int ss = 0;
            for (int i = 1; i < list.size(); i++) {
                ss += computeTiming(list.get(i-1), list.get(i));
            }
            map2.put(date, ss);
        }
        ArrayList<String> list = new ArrayList<>(map2.keySet());
        Collections.sort(list);
        boolean isValid = false;
        for (String i : list) {
            int ss = map2.get(i);
            if(ss <= 0) {
                continue;
            }
            System.out.println(i + " " + ss);
            isValid = true;
        }
        if(!isValid) {
            System.out.println(-1);
        }
    }

    public static int computeTiming(String[] x, String[] y) {
        int res = 0;
        int x0 = change(x[0]);
        int x1 = change(x[1]);
        int x2 = change(x[2]);
        int y0 = change(y[0]);
        int y1 = change(y[1]);
        int y2 = change(y[2]);
        if((x0 == 12 && x1 <= 29 && x2 <= 59) || x0 < 12) {  //x 在12点30之前
            if(y0 >= 12 && y0 < 14) {   //y 在休息期间
                if(!(y0 == 12 && y1 >= 30)) {
                    y0 = 12;
                    y1 = 29;
                    y2 = 59;
                }
            }
            else if(y0 >= 14) { //y 在14点之后
                res += (12-x0)*3600 + (29-x1)*60 + (59-x2);
                return res;
            }
        }
        else if((x0 > 12 && x0 < 14) || (x0 == 12 && x1 >= 30)) {   //x在休息期间
            if((y0 > 12 && y0 < 14) || (y0 == 12 && y1 >= 30)) {    //y也在休息期间
                return 0;
            }
            else {  //y在14点以后
                x0 = 14;
                x1 = 0;
                x2 = 0;
            }
        }
        if(x[0].equals(y[0])) {
            if(x[1].equals(y[1])) {
                res += (y2-x2);
            }
            else {
                res += (y1-x1)*60;
                res += (y2-x2);   //秒数即使是负的也要这样加
            }
        }
        else {
            res += (y0-x0)*3600;
            res += (y1-x1)*60;
            res += (y2-x2);
        }
        return res;
    }
    public static int change(String t) {
        int res = 0;
        if(t.charAt(0) == '0' && t.trim().length() > 1) {
            res = Integer.parseInt(String.valueOf(t.charAt(1)));
        }
        else {
            res = Integer.parseInt(t);
        }
        return res;
    }
}
