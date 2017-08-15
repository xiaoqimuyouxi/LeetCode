package conclusion.proxy.staticProxy;

/**
 * 代理类，比如代理商，只会买东西，并不会改变行为，不会制造东西
 *
 * 例如通过黄牛买票，黄牛就是一个代理，黄牛可以实现realObject的某些方法，也可以屏蔽一些方法实现，比如改签退票只能去车站
 *
 * 例如客户有需求提出时如果直接联系程序员，程序员会让其去找产品经理，这里产品经理就是程序员的一个代理类，程序员实现类就是委托类，
 *      抽象角色即为一个实现用户需求的方法的接口或抽象类，真是角色是码农要实现需求，代理角色是产品经理担当，他可以过滤掉一些需求或者在用户提出需求之外再增加
 *      一些需求等。
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
