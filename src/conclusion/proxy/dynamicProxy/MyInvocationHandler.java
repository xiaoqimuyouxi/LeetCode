package conclusion.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * 如果要在方法执行的前后打印系统时间，如果只有一个方法需要这样做，那么采用静态代理绝对没问题，但是如果有10个上百个方法都需要这样做，那么就会写10个上百个
 * 完全相同的代码，这样做是非常不理想的。  所以出现了动态代理
 *
 * 动态代理是 代理类在程序运行时动态创建的代理方式
 * Created by ly on 2017/4/10.
 */
public class MyInvocationHandler implements InvocationHandler {
    public Object target;   //需要代理的委托类

    public MyInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("begin");
        Object result = method.invoke(target, args);
        System.out.println("end");

        return result;
    }

    //生成代理对象
    public Object getProxy() {
        ClassLoader loader = Thread.currentThread().getContextClassLoader();    //获得类加载器
        Class<?>[] interfaces = target.getClass().getInterfaces();
        return Proxy.newProxyInstance(loader, interfaces, this);
    }
}
