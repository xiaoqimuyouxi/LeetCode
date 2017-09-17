package exam.thoughtworks;

/**
 * Created by ly on 2017/9/11.
 */
public class OrderInfo {
    private String user;
    private String date;
    private int start;
    private int end;
    private String time;
    private String plat;
    private boolean isCancel;
    private int count = 0;
    private String echo;
    private int money;
    public OrderInfo() {

    }
    public OrderInfo(String user, String date, int start, int end, String time, String plat, boolean isCancel) {
        this.user = user;
        this.date = date;
        this.start = start;
        this.end = end;
        this.time = time;
        this.plat = plat;
        this.isCancel = isCancel;
    }

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

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getEcho() {
        return echo;
    }

    public void setEcho(String echo) {
        this.echo = echo;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
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
        if(user.equals(order.user) && date.equals(order.date) && start == order.start && end == order.end &&
                plat.equals(order.plat)) {
            return true;
        }
        else return false;
    }

    @Override
    public int hashCode() {
        return date.hashCode()+plat.hashCode()+time.hashCode();
    }

    @Override
    public String toString() {
        return date+" " + time + " " + getEcho();
    }

    /**
     * 判断两个时间段是否有重复
     * @param
     * @param
     * @return
     */
    public boolean isDuplicate(OrderInfo order2) {
        if(!date.equals(order2.date) || !plat.equals(order2.plat)) {    //日期和场地不同
            return false;
        }
        int m1 = getStart(), m2 = getEnd();
        int n1 = order2.getStart(), n2 = order2.getEnd();
        if(m2 <= n1 || m1 >= n2) {  //没有重复
            return false;
        }
        return true;
    }
}
