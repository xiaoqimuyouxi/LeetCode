package conclusion.countDownLatch;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * 服务具体实现类
 * Created by ly on 2017/4/10.
 */
public class HealthCheckService extends Service {
    public HealthCheckService(CountDownLatch latch) {
        super(latch);
    }

    @Override
    public void execute() {
        try {
            TimeUnit.SECONDS.sleep(2);  //模拟长时间的等待操作
            System.out.println("健康检查完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

class DataBaseCheckService extends Service {

    public DataBaseCheckService(CountDownLatch latch) {
        super(latch);
    }

    @Override
    public void execute() {
        try {
            TimeUnit.SECONDS.sleep(2);  //模拟长时间的等待操作
            System.out.println("数据库检查完成");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
