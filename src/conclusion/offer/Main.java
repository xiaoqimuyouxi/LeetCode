package conclusion.offer;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ly on 2017/9/14.
 */
@SuppressWarnings("all")
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine().trim();
        String[] data = s.split(",");
        if(data.length != 3){
            System.out.println("incorrect data");
            return;
        }
        int n = Integer.parseInt(data[0]);
        String[] start = data[1].split(" ");
        String[] end = data[2].split(" ");
        if(start.length != 2 || end.length != 2) {
            System.out.println("incorrect data");
            return;
        }
        if(!checkDate(start[0]) || !checkDate(end[0])) {
            System.out.println("incorrect data");
            return;
        }

        String[] begin = start[1].split(":");
        String[] over = end[1].split(":");
        if(begin.length != 3 || over.length != 3) {
            System.out.println("incorrect data");
            return;
        }
        int hour = 0;
        int minute = 0;
//        int second;
        for (int i = 0; i < begin.length-1; i++) {
            int h1 = changeTime(begin[i]);
            int h2 = changeTime(over[i]);
            if(i == 0) {
                if(checkTime(h1, 24) && checkTime(h2, 24) && h1 <= h2) {
                    hour = (h2-h1)*60;
                }
                else {
                    System.out.println("incorrect data");
                    return;
                }
                continue;
            }
            if(checkTime(h1, 60) && checkTime(h2, 60)) {
                minute = h2-h1;
            }
        }
        int sum = hour + minute;
        int sumTime = (n-1)*15;
        int circle = sum/sumTime;
        System.out.println(circle + ";");
        int location = sum%sumTime;

    }
    public static boolean checkDate(String date) {
        /**
         * 判断日期格式和范围
         */
        String rexp = "^((\\d{2}(([02468][048])|([13579][26]))[\\-\\/\\s]?((((0?[13578])|(1[02]))[\\-\\/\\s]?((0?[1-9])" +
                "|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?" +
                "((0?[1-9])|([1-2][0-9])))))|(\\d{2}(([02468][1235679])|([13579][01345789]))[\\-\\/\\s]?((((0?[13578])|" +
                "(1[02]))[\\-\\/\\s]?((0?[1-9])|([1-2][0-9])|(3[01])))|(((0?[469])|(11))[\\-\\/\\s]?((0?[1-9])|" +
                "([1-2][0-9])|(30)))|(0?2[\\-\\/\\s]?((0?[1-9])|(1[0-9])|(2[0-8]))))))";

        Pattern pat = Pattern.compile(rexp);

        Matcher mat = pat.matcher(date);

        boolean dateType = mat.matches();

        return dateType;
    }
    public static int changeTime(String t) {
        int res = 0;
        if(t.charAt(0) == '0' && t.trim().length() > 1) {
            res = Integer.parseInt(String.valueOf(t.charAt(1)));
        }
        else {
            res = Integer.parseInt(t);
        }
        return res;
    }

    public static boolean checkTime(int time, int target) {
        if(time > target) {
            return false;
        }
        return true;
    }
}
