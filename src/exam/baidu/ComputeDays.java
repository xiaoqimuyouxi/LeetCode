package exam.baidu;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by ly on 2017/9/16.
 */
public class ComputeDays {
    Object o = new Object();

    public static int getDays(int numOfPlants, int[] plantHeight) {
        if(numOfPlants <= 0 || plantHeight == null || plantHeight.length != numOfPlants) {
            return 0;
        }
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < numOfPlants - 1; i++) {
            if(plantHeight[i] > plantHeight[i+1]) {
                list.add(i);
            }
        }
        int sum = 0;
        int index = 0;
        while (list.size() > 0) {
            int init = list.size();
            int i = index;
            for(; i < init; i++) {
                int left = list.get(i)-1;
                if(list.contains(left) || left < 0) {
                    continue;
                }
                int right = list.get(i)+1;
                while (list.contains(right)) {
                    right++;
                }
                if(plantHeight[left] > plantHeight[right])
                    list.add(left);
            }
            index += i;
            sum++;
            if(list.size() == init) break;
        }
        return sum+1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        boolean[] tags = new boolean[n];
//        System.out.println(getDays(n, arr));
        System.out.println(pullPlants(arr, tags));
    }

    public static int pullPlants(int[] plants, boolean[] tags) {
        boolean isPull = false;
        int left = 0;
        int right = 0;
        for (int i = 0; i < plants.length; i++) {
            if(!tags[i]){   //没有标记
                if(left == 0) {
                    left = plants[i];
                }
                else if(right == 0) {
                    right = plants[i];
                    if(left < right) {  //右边的大于左边的
                        tags[i] = true;
                        isPull = true;
                    }
                    left = right;
                    right = 0;
                }
            }
        }
        if(!isPull) {
            return 0;
        }
        else return 1+pullPlants(plants, tags);
    }
}
