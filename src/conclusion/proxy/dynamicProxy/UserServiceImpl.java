package conclusion.proxy.dynamicProxy;

/**
 * 委托类
 * Created by ly on 2017/4/10.
 */
public class UserServiceImpl implements Service {
    @Override
    public void add() {
        System.out.println("this is User service!");
    }
}
