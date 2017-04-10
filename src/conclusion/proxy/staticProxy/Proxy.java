package conclusion.proxy.staticProxy;

/**
 * 代理类
 * Created by ly on 2017/4/10.
 */
public class Proxy implements Subject {
    private Subject subject;
    public Proxy(Subject subject) {
        this.subject = subject;
    }

    @Override
    public void request() {
        System.out.println("begin");
        subject.request();
        System.out.println("end");
    }
}
