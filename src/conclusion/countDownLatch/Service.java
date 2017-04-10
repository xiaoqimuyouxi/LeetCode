package conclusion.countDownLatch;

import java.util.concurrent.CountDownLatch;

/**
 *
 *
 * 所有服务的基类
 * Created by ly on 2017/4/10.
 */
public class Service implements Runnable {
    private CountDownLatch latch;
    public Service(CountDownLatch latch) {
        this.latch = latch;
    }

    @Override
    public void run() {
        try {
            execute();
        } finally {
            if(latch != null) {
                latch.countDown();
            }
        }
    }

    public void execute() {}
}
