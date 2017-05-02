package conclusion.proxy.staticProxy;

/**
 * 在静态代理模式中，一个委托类对应一个代理类，代理类在编译期间就已经确定
 *
 * 缺点：
 *      1）需要自己手动编写大量的代理类，会改变原有的代码，改的多了就会出现问题
 *      2）会出现很多不必要的重复代码
 *      3）在编译器就加入了代理类，系统的灵活性非常差
 * Created by ly on 2017/4/10.
 */
public class ProxyTest {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);   //代理realSubject这个委托类
        proxy.request();
    }
}
