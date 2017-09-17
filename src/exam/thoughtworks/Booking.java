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
    ArrayList<OrderInfo> order = new ArrayList<>();
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
                            LocalDate tt = LocalDate.parse(data[i]);
                            DayOfWeek day = tt.getDayOfWeek();
                            week = tt.getDayOfWeek();
                        }
                    }
                    else if(i == 2) {
                        if(!checkTime(data[i], info)){
                            System.out.println("Error: the booking is invalid!");
                            isValid = false;
                            break;
                        }
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
                info.setTime(data[2]);
                info.setPlat(data[3]);
                info.setCancel(isCancle);

                if(!isCancle) {
                    for(OrderInfo info2 : order) {
                        if(info.isDuplicate(info2)) {   //二者时间有重叠时
                            if(info2.getCount() == 0) { //之前的预定没有被取消
                                System.out.println("Error: the booking conflicts with existing bookings!");
                                isValid = false;
                                break;
                            }
                        }
                    }
                    if(!isValid) {
                        continue;
                    }
                }

                if(order.contains(info)) {
                    int index = order.indexOf(info);
                    OrderInfo info2 = order.get(index);
                    String money = info2.getEcho();
                    if(isCancle) {
                        if(money.contains("违约金")){  //表示要取消的订单并不存在
                            System.out.println("Error: the booking being cancelled does not exist!");
                            continue;
                        }
                        int m = Integer.parseInt(money.substring(0, money.length()-1)); //把元的单位去掉
                        float res = m * checkWeek(week);
                        info.setCount(info.getCount()+1);   //违约次数加1
                        info.setEcho("违约金 " + (int)res + "元");
                        info.setMoney((int)res);
                        order.remove(info2);    //删除原来的
                        order.add(info);
                    }
                    else {  //预定时间冲突
                        //前面相同时间的已经取消了
                        if(money.contains("违约金")){
                            String plat = info.getPlat();
                            info = new OrderInfo(info.getUser(), info.getDate(), info.getStart(), info.getEnd(),info.getTime(),
                                    plat+info.getCount(), info.isCancel()); //场地加上违约次数，与之前违约的预定区别开来
                            //这里会覆盖掉之前违约的预定，所以采用一个改变plat后的新对象
                            int mm = computeCost(info, week);
                            info.setCount(0);
                            info.setEcho(mm + "元");
                            info.setMoney(mm);
                            order.remove(info2);
                            order.add(info);
                        }
                        else {
                            System.out.println("Error: the booking conflicts with existing bookings!");
                            continue;
                        }
                    }
                }
                else {  //计算该预定所需的费用
                    if(isCancle) {
                        System.out.println("Error: the booking being cancelled does not exist!");
                        continue;
                    }
                    int money = computeCost(info, week);
                    info.setEcho(money + "元");
                    info.setMoney(money);
                    info.setCount(0);
                    order.add(info);
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

        Collections.sort(order, new Comparator<OrderInfo>() {
            @Override
            public int compare(OrderInfo o1, OrderInfo o2) {
                String plat1 = o1.getPlat().substring(0, 1);    //由于为了使得违约后的时间点仍然可以预定场地，所以在场地后面加上了编号
                String plat2 = o2.getPlat().substring(0, 1);
                if(plat1.equals(plat2)) {
                    if(o1.getDate().equals(o2.getDate())) {
                        return o1.getStart()-o2.getStart(); //时间越小表示越早
                    }
                    else return o1.getDate().compareTo(o2.getDate());
                }
                else {
                    return plat1.compareTo(plat2);
                }
            }
        });

        printRevenue(order);
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

    /**
     * 将格式化的时间转换成可以计算的整型值
     * @param t
     * @return
     */
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

    /**
     * 计算在预定的时间段内的开销
     * @param info
     * @param week
     * @return
     */
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
/*
    *//**
     * 判断是否是违约金
     * @param money
     * @return
     *//*
    public String isBreak(String money) {
        String mint = "";
        if(money.contains("违约金")) {
            money = money.trim();
            for (int j = 0; j < money.length(); j++) {
                if(money.charAt(j) >= 48 && money.charAt(j) <= 57) {
                    mint += money.charAt(j);
                }
            }
        } else {
            mint = money.substring(0, money.length()-1);
        }
        return mint;
    }*/


    /**
     * 打印管理员的收入情况
     * @param set
     */
    public void printRevenue(ArrayList<OrderInfo> set) {
        System.out.println("收入汇总");
        System.out.println("---");
        int countA=0, countB=0, countC=0, countD=0;
        int i = 0;
        System.out.println("场地：A");
        for (; i < set.size(); i++) {
            OrderInfo info = set.get(i);
            if(!info.getPlat().contains("A")) {
                break;
            }
            int mm = info.getMoney();    //排除中文字符
            countA += mm;
            System.out.println(info.toString());
        }
        System.out.println("小计：" + countA + "元");
        System.out.println();

        System.out.println("场地：B");
        for (; i < set.size(); i++) {
            OrderInfo info = set.get(i);
            if(!info.getPlat().contains("B")) {
                break;
            }
            int mm = info.getMoney();    //排除中文字符
            countB += mm;
            System.out.println(info.toString());
        }
        System.out.println("小计：" + countB + "元");
        System.out.println();

        System.out.println("场地：C");
        for (; i < set.size(); i++) {
            OrderInfo info = set.get(i);
            if(!info.getPlat().contains("C")) {
                break;
            }
            int mm = info.getMoney();    //排除中文字符
            countC += mm;
            System.out.println(info.toString());
        }
        System.out.println("小计：" + countC + "元");
        System.out.println();

        System.out.println("场地：D");
        for (; i < set.size(); i++) {
            OrderInfo info = set.get(i);
            if(!info.getPlat().contains("D")) {
                break;
            }
            int mm = info.getMoney();    //排除中文字符
            countD += mm;
            System.out.println(info.toString());
        }
        System.out.println("小计：" + countD + "元");
        System.out.println("---");
        System.out.println("总计：" + (countA+countB+countC+countD) + "元");
    }
}
