package conclusion.countDownLatch;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 应用场景：
 *      应用程序的主程序希望  在负责启动框架服务的线程已经完成之后  再执行
 * Created by ly on 2017/4/10.
 */
public class Application {

    private CountDownLatch latch;
    public void setUp() throws InterruptedException {
        latch = new CountDownLatch(2);  //需要等待两个线程操作完成
        List<Service> services = new ArrayList<>();
        services.add(new HealthCheckService(latch));
        services.add(new DataBaseCheckService(latch));
        Executor executor = Executors.newFixedThreadPool(services.size());
        for ( Service service : services) {
            executor.execute(service);
        }
        latch.await();
        System.out.println("all service is start up");
    }

    public static void main(String[] args) throws InterruptedException {
        Application app = new Application();
        app.setUp();
    }
}
