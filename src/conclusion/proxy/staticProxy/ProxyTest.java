package conclusion.proxy.staticProxy;

/**
 * 在静态代理模式中，一个委托类对应一个代理类，代理类在编译期间就已经确定
 * Created by ly on 2017/4/10.
 */
public class ProxyTest {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        Proxy proxy = new Proxy(realSubject);   //代理realSubject这个委托类
        proxy.request();
    }
}
