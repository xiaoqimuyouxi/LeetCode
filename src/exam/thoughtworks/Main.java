package exam.thoughtworks;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by ly on 2017/9/10.
 */
public class Main {
    public static void main(String[] args) throws IOException{
        BufferedReader br = null;
        br = new BufferedReader(new InputStreamReader(System.in));
        String s;
        int count = 0;
        while ((s = br.readLine()) != null) {
            if(s.equals("")) break;
            System.out.println(++count);
        }
    }
}
