package exam.nowcoderHuaWei;

import java.util.Scanner;

/**
 * 扑克牌大小
 *
 * 输入两副牌
 * 输出大的那副牌
 * Created by ly on 2017/8/16.
 */
public class PuKePai {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s;
        String[] car1;
        String[] car2;
        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if(line.contains("joker JOKER")) {
                System.out.println("joker JOKER");
            }
            else {
                s = line.split("-");
                car1 = s[0].split(" ");
                car2 = s[1].split(" ");

                //炸弹最大
                if(car1.length == 4 && car2.length != 4) {
                    System.out.println(s[0]);
                }
                else if(car1.length != 4 && car2.length == 4) {
                    System.out.println(s[1]);
                }
                else if(car1.length == car2.length) {
                    if(count(car1[0]) > count(car2[0])) {
                        System.out.println(s[0]);
                    }
                    else System.out.println(s[1]);
                }
                else {
                    System.out.println("ERROR");
                }
            }
        }
    }

    public static int count(String string) {
        return "345678910JQKA2jokerJOKER".indexOf(string);
    }
}
