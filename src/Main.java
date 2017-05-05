import java.util.ArrayList;

/**
 * Created by ly on 2016/12/23.
 */
public class Main {

    public static void main(String[] args) {
        Main m1 = new Main();
        Demo demo = new Demo();
        System.out.println(demo);
        test(demo);
        System.out.println(demo);
        int a = 8;
        test1(a);
        System.out.println(a + "  "+ m1.d);
    }

    private static int d ;
    public void setD(int d) {
        this.d = d;
    }

    private static void test(Demo demo){
        demo = null;
    }

    private static void test1(int s){
        s++;
        Main m = new Main();
        m.setD(45);
    }


}

