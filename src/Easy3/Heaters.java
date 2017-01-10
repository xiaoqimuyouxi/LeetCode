package Easy3;

import java.util.Arrays;

/**
 * 475题
 * 求加热器能够覆盖所有房子的最小半径
 * 先将所有的房子和加热器按照先后顺序排好，
 * 因为如果一个房子已经确定了离他最近的加热器，那么他后面的房子离它最近的加热器肯定是在这个及这个的后面加热器。
 * Created by ly on 2017/1/10.
 */
public class Heaters {
    //22ms
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
