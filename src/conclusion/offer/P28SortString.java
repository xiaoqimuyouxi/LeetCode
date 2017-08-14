package conclusion.offer;

import java.util.ArrayList;
import java.util.Collections;

/**
 * 字符串的全排列
 * Created by ly on 2017/8/7.
 */
public class P28SortString {
    ArrayList<String> res = new ArrayList<>();
    public ArrayList<String> Permutation(String str) {
        if(str == null || str.trim().length() == 0) {
            return res;
        }
        str = str.trim();
        Permutation(str.toCharArray(), 0);
        Collections.sort(res);
        return res;
    }

    public void Permutation(char[] arr, int start) {
        if(start == arr.length-1) {
            res.add(String.valueOf(arr));
        }
        else {
            for (int i = start; i < arr.length; i++) {
                if(i == start || arr[i] != arr[start]) {
                    swap(arr, i, start);
                    Permutation(arr, start+1);
                    swap(arr, i, start);    //复位
                }
            }
        }
    }

    public void swap (char[] arr, int i, int j) {
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

}
