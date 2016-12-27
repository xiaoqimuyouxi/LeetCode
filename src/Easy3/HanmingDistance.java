package Easy3;

/**
 * 461题     汉明距离
 * Created by ly on 2016/12/26.
 */
public class HanmingDistance {
    //10ms
    public int hammingDistance(int x, int y) {

        int c = 0;
        while (x != 0 || y != 0) {
            if(((x^y)&1) == 1) {
                c++;
            }
            x >>>= 1;
            y >>>= 1;
        }
        return c;
    }

    public static void main(String[] args) {
        HanmingDistance h = new HanmingDistance();
        System.out.println(h.hammingDistance(93, 73));
    }
}
