package exam.thoughtworks;

import java.io.*;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ly on 2017/9/9.
 */
@SuppressWarnings("all")
public class Booking {
    HashMap<OrderInfo, String> order = new HashMap<>();
    public void acceptOrder() {
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(System.in));
            String s;
            while ((s = br.readLine()) != null) {
                if(s.equals(""))    break;  //空行输入表示结尾
                String[] data = s.split(" ");
                DayOfWeek week = null;
                if(data.length < 4 || data.length > 5) {
                    System.out.println("Error: the booking is invalid!");
                    continue;
                }
                boolean isValid = true;
                OrderInfo info = new OrderInfo();
                for (int i = 0; i < 4; i++) {
                    if(i == 0 && !checkUserID(data[i])) {
                        System.out.println("Error: the booking is invalid!");
                        isValid = false;
                        break;
                    }
                    else if(i == 1) {
                        if(!checkDate(data[i])) {
                            System.out.println("Error: the booking is invalid!");
                            isValid = false;
                            break;
                        }
                        else {
//                            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
//                            String[] date = data[i].split("-");
                            LocalDate tt = LocalDate.parse(data[i]);
//                            Date dt = new Date(changeTime(date[0]), changeTime(date[1]), changeTime(date[2]));
//                            week = sdf.format(dt);
                            DayOfWeek day = tt.getDayOfWeek();
                            week = tt.getDayOfWeek();
                        }
                    }
                    else if(i == 2 && !checkTime(data[i], info)) {
                        System.out.println("Error: the booking is invalid!");
                        isValid = false;
                        break;
                    }
                    else if(i == 3) {
                        if(data[i].length() != 1) {
                            System.out.println("Error: the booking is invalid!");
                            isValid = false;
                            break;
                        }
                        else {
                            if(!"ABCD".contains(data[i])) {
                                System.out.println("Error: the booking is invalid!");
                                isValid = false;
                                break;
                            }
                        }
                    }
                }
                if(!isValid) {
                    continue;
                }
                boolean isCancle = false;
                if(data.length == 5) {
                    if(data[4].equals("C")){
                        isCancle = true;
                        isValid = true;
                    }
                    else {
                        isValid = false;
                    }
                }
                if(!isValid) {
                    System.out.println("Error: the booking is invalid!");
                    continue;
                }
                info.setUser(data[0]);
                info.setDate(data[1]);
                info.setPlat(data[3]);
                info.setCancel(isCancle);
                if(order.containsKey(info)) {
                    if(isCancle) {
                        String money = order.get(info);
                        int m = Integer.parseInt(money.substring(0, money.length()-1)); //把元的单位去掉
                        float res = m * checkWeek(week);
                        order.put(info, "违约金 " + res + "元");
                    }
                    else {  //预定时间冲突
                        System.out.println("Error: the booking conflicts with existing bookings!");
                        continue;
                    }
                }
                else {  //计算该预定所需的费用
                    if(isCancle) {
                        System.out.println("Error: the booking being cancelled does not exist!");
                        continue;
                    }
                    int money = computeCost(info, week);
                    order.put(info, money + "元");
                }
                System.out.println("Success: the booking is accepted!");
            }
        }catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(br != null) {
                    br.close();
                }
            }catch (IOException e) {
                e.printStackTrace();
            }
        }

        System.out.println("收入汇总");
        System.out.println("---");
        ArrayList<OrderInfo> set = new ArrayList<>(order.keySet());
        Collections.sort(set, new Comparator<OrderInfo>() {
            @Override
            public int compare(OrderInfo o1, OrderInfo o2) {
                if(o1.getPlat().equals(o2.getPlat())) {
                    if(o1.getDate().equals(o2.getDate())) {
                        return o1.getStart()-o2.getStart(); //时间越小表示越早
                    }
                    else return o1.getDate().compareTo(o2.getDate());
                }
                else {
                    return o1.getPlat().compareTo(o2.getPlat());
                }
            }
        });

        int countA=0, countB=0, countC=0, countD=0;
        for (int i = 0; i < set.size(); i++) {
            OrderInfo info = set.get(i);
            if(info.getPlat().equals("A") && countA == 0) {
                System.out.println("场地：A");
            }
            else if(info.getPlat().equals("B") && countB == 0) {
                System.out.println("小计：" + countA + "元");
                System.out.println("场地：B");
            }
            else if(info.getPlat().equals("C") && countC == 0) {
                System.out.println("小计：" + countB + "元");
                System.out.println("场地：C");
            }
            else if(info.getPlat().equals("D") && countD == 0){
                System.out.println("小计：" + countC + "元");
                System.out.println("场地：D");
            }
            String money = order.get(info);
            int mm = Integer.parseInt(money.substring(0, money.length()-1));    //排除中文字符
            if(info.getPlat().equals("A")) countA += mm;
            else if(info.getPlat().equals("B")) countB += mm;
            else if(info.getPlat().equals("C")) countC += mm;
            else if(info.getPlat().equals("D")) countD += mm;
            System.out.println(info.toString() + " " + money);
        }
        System.out.println("小计：" + countD + "元");
        System.out.println("---");
        System.out.println("总计：" + (countA+countB+countC+countD) + "元");
    }

    /**
     * 判断用户ID是否合法，这里因为不清楚题目要求合法输入是怎样的，所以只写一个空方法的接口在这里
     * @param user  需要判断的用户ID
     * @return
     */
    public boolean checkUserID(String user) {
        return true;
    }

    /**
     * 检查日期格式是否正确
     * @param date
     * @return
     */
    public boolean checkDate(String date) {
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

    /**
     * 判断预定时间是否有效
     * @param time
     * @return
     */
    public boolean checkTime(String time, OrderInfo info) {
        String[] whole = time.split("~");
        if(whole.length != 2) {
            return false;
        }
        int h1 = 0, h2 = 0;
        for (int i = 0; i < 2; i++) {
            String[] t = whole[i].split(":");
            if(t.length != 2) {
                return false;
            }
            int hour = changeTime(t[0]);
            if(i == 0) h1 = hour;
            else if(i == 1) h2 = hour;
            if(hour < 9 || hour > 22) {
                return false;
            }
            int minute = changeTime(t[1]);
            if(minute != 0) {
                return false;
            }
        }
        if(h1 >= h2) return false;
        info.setStart(h1);
        info.setEnd(h2);
        return true;
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

    /**
     * 判断是工作日还是周末
     * @param week
     * @return 0.5 表示工作日所扣违约金比例，0.25 表示周末所扣违约金比例
     */
    public float checkWeek(DayOfWeek week) {
        if(week == null) {
            return 0;
        }
        if(week == DayOfWeek.SATURDAY || week == DayOfWeek.SUNDAY) {
            return (float) 0.25;
        }
        else {
            return (float) 0.5;
        }
    }

    public int computeCost(OrderInfo info, DayOfWeek week) {
        int start = info.getStart();
        int end = info.getEnd();
        int count = 0;
        if(week == DayOfWeek.SUNDAY || week == DayOfWeek.SATURDAY) {
            if(end <= 12) {
                count += (end-start)*40;
            }
            else if(start <= 12 && end > 12 && end <= 18) {
                count += (12-start)*40 + (end-12)*50;
            }
            else if(start <= 12 && end > 18) {
                count += (12-start)*40+6*50+(end - 18)*60;
            }
            else if(start > 12 && start <= 18 && end > 18) {
                count += (18-start)*50 + (end-18)*60;
            }
            else if(start > 12 && end <= 18) {
                count += (end-start)*50;
            }
            else if(start >= 18) {
                count += (end - start) * 60;
            }
        }
        else {
            if(end <= 12) {
                count += (end-start)*30;
            }
            else if(start <= 12 && end > 12 && end <= 18) {
                count += (12-start)*30 + (end-12)*50;
            }
            else if(start <= 12 && end > 18 && end <= 20) {
                count += (12-start)*30+6*50+(end - 18)*80;
            }
            else if(start <= 12 && end > 20) {
                count += (12-start)*30 + 6*50 + 2*80 + (end-20)*60;
            }
            else if(start > 12 && end <= 18) {
                count += (end-start)*50;
            }
            else if(start > 12 && start <= 18 && end > 18 && end <= 20) {
                count += (18-start)*50 + (end-18)*80;
            }
            else if(start > 12 && start <= 18 && end > 20) {
                count += (18-start)*50 + 2*80 + (end - 20)*60;
            }
            else if(start > 18 && end <= 20) {
                count += (end - start) * 80;
            }
            else if(start > 18 && start <= 20 && end > 20) {
                count += (20-start)*80 + (end-20)*60;
            }
            else if(start > 20) {
                count += (end-start)*60;
            }
        }
        return count;
    }

    static class OrderInfo{
        String user;
        String date;
        int start;
        int end;
        String plat;
        boolean isCancel;
        public OrderInfo() {

        }
        /*public OrderInfo(String user, String date, String time, String plat, boolean isCancel) {
            this.user = user;
            this.date = date;
            this.time = time;
            this.plat = plat;
            this.isCancel = isCancel;
        }*/

        public String getUser() {
            return user;
        }

        public void setUser(String user) {
            this.user = user;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }

        public String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getPlat() {
            return plat;
        }

        public void setPlat(String plat) {
            this.plat = plat;
        }

        public boolean isCancel() {
            return isCancel;
        }

        public void setCancel(boolean cancel) {
            isCancel = cancel;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if(obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            OrderInfo order = (OrderInfo) obj;
            if(isCancel) {
                if(user.equals(order.user) && date.equals(order.date) && start == order.start && end == order.end &&
                        plat.equals(order.plat)) {
                    return true;
                }
                else return false;
            }
            else {
                if(date.equals(order.date) && plat.equals(order.plat)) {
                    if(isDuplicate(this, order)) { //预定时间冲突
                        return false;
                    }
                    else return true;
                }
                else return true;
            }
        }

        @Override
        public int hashCode() {
            return date.hashCode()+plat.hashCode();
        }

        @Override
        public String toString() {
            String begin;
            if(start < 10) {
                begin = 0+""+start;
            }
            else begin = start+"";
            String finish;
            if(end < 10) {
                finish = 0+""+end;
            }
            else finish = end+"";
            String s = date +" " + begin + ":00~" + finish + ":00";
            return s;
        }
    }

    /**
     * 判断两个时间段是否有重复
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isDuplicate(OrderInfo order1, OrderInfo order2) {
        int m1 = order1.getStart(), m2 = order1.getEnd();
        int n1 = order2.getStart(), n2 = order2.getEnd();
        if(m2 >= n1 || m1 <= n2) {  //没有重复
            return false;
        }
        return true;
    }

    /*static class test{
        String user;
        public test(String user) {
            this.user = user;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj) {
                return true;
            }
            if(obj == null || obj.getClass() != this.getClass()) {
                return false;
            }
            test t = (test)obj;
            if(user.equals(t.user)) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return user.hashCode();
        }
    }*/
    public static void main(String[] args) {
        /*test t1 = new test("aa");
        test t2 = new test("aa");
        System.out.println(t1.equals(t2));*/

        Booking book = new Booking();
        book.acceptOrder();
    }
}
