package conclusion.overflow;

/**
 * Created by ly on 2017/8/23.
 */
public class StackLeak {
    public static void main(String[] args) {
        method();
    }
    public static void method(){
        method();
    }
}
