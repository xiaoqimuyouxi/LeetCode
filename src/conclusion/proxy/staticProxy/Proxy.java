package conclusion.proxy.staticProxy;

/**
 * 代理类，比如代理商，只会买东西，并不会改变行为，不会制造东西
 *
 * 例如通过黄牛买票，黄牛就是一个代理，黄牛可以实现realObject的某些方法，也可以屏蔽一些方法实现，比如改签退票只能去车站
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
