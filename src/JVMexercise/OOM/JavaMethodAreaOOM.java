package JVMexercise.OOM;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * JDK1.8 移除了永久代的概念，所以就没有PermSize的参数配置了
 * VM args: -XX:PermSize=10M -XX:MaxPermSize=10M
 *
 * 方法区用于存放Class类的相关信息，如类名、访问修饰符、常量池、字段描述、方法描述等
 *
 * 借助CGLib使方法区出现内存溢出异常
 * Created by ly on 2017/7/15.
 */
public class JavaMethodAreaOOM {
    static class OOMObject{

    }

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(OOMObject.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                @Override
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });
            enhancer.create();
        }
    }
}
