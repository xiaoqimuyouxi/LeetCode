package conclusion.offer.baidu;

import java.util.*;

/**
 * 度度熊想去商场买一顶帽子，商场里有N顶帽子，有些帽子的价格可能相同。度度熊想买一顶价格第三便宜的帽子，问第三便宜的帽子价格是多少？
 * Created by ly on 2017/5/5.
 */
public class BuyHat {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            int tmp = scanner.nextInt();
            if(!list.contains(tmp)) {
                list.add(tmp);
            }
        }

        Collections.sort(list);
        if(list.size() < 3) {
            System.out.println(-1);
        }
        else {
            System.out.println(list.get(2));
        }
    }
}
