package conclusion.proxy.dynamicProxy;

/**
 * Created by ly on 2017/4/10.
 */
public class ProxyTest {
    public static void main(String[] args) {
        Service service = (Service) new UserServiceImpl();
        MyInvocationHandler handler = new MyInvocationHandler(service);
        Service serviceProxy = (Service) handler.getProxy();
        serviceProxy.add();
    }
}
