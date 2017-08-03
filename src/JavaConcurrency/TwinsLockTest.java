package JavaConcurrency;

import org.junit.Test;
import java.util.concurrent.locks.Lock;

/**
 * Created by ly on 2017/8/2.
 */
public class TwinsLockTest {
    @Test
    public void test() {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            @Override
            public void run() {
                while (true) {
                    lock.lock();    //不能在try中获得锁，因为如果try中出现异常导致没有获得锁，而此时finally又会释放锁容易造成错误
                    try {
                        ThreadState.SleepUtil.second(1);
                        System.out.println(Thread.currentThread().getName());
                        ThreadState.SleepUtil.second(1);
                    } finally {
                        lock.unlock();
                    }
                }
            }
        }

        //启动10个线程
        for (int i = 0; i < 10; i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
        }

        //每隔一秒换行
        for (int i = 0; i < 10; i++) {
            ThreadState.SleepUtil.second(1);
            System.out.println();
        }
    }
}
