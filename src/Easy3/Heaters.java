package Easy3;

import java.util.Arrays;

/**
 * 475题
 * 求加热器能够覆盖所有房子的最小半径
 * Created by ly on 2017/1/10.
 */
public class Heaters {
    public int findRadius(int[] houses, int[] heaters) {
        Arrays.sort(houses);
        Arrays.sort(heaters);
        int m = houses.length, n = heaters.length;
        if(m==0 || n==0) {
            return 0;
        }
        int r = 0, index = 0;
        for(int i = 0; i < m; i++) {
            int tr = Math.abs(heaters[index]-houses[i]);
            for(int j = index+1; j < n; j++) {
                if(Math.abs(heaters[j]-houses[i]) <= tr) {
                    tr = Math.abs(heaters[j]-houses[i]);
                    index = j;
                }
                else
                    break;
            }
            r = Math.max(r, tr);
        }
        return r;
    }

    public static void main(String[] args) {
        Heaters h = new Heaters();
        int[] houses = {1,2,3,5,15};
        int[] heaters = {2,30};
        System.out.println(h.findRadius(houses, heaters));
    }
}
