package conclusion.proxy.staticProxy;

/**
 * 委托类
 * Created by ly on 2017/4/10.
 */
public class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("委托类");
    }
}
