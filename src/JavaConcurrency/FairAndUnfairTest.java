package JavaConcurrency;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by ly on 2017/8/2.
 */
public class FairAndUnfairTest {
    private static class ReentrantLock2 extends ReentrantLock {
        ReentrantLock2(boolean fair) {
            super(fair);
        }

        @Override
        protected Collection<Thread> getQueuedThreads() {
            List<Thread> arrayList = new ArrayList<>(super.getQueuedThreads()); //列表是逆序输出，所以将其反转
            Collections.reverse(arrayList);
            return arrayList;
        }
    }

    private static ReentrantLock2 fairLock = new ReentrantLock2(true);
    private static ReentrantLock2 unfairLock = new ReentrantLock2(false);

    @Test
    public void fair() {
        testLock(fairLock);
    }

    @Test
    public void unfair() {
        testLock(unfairLock);
    }

    private void testLock(ReentrantLock2 lock) {
        //启动5个job
        for (int i = 0; i < 10; i++) {
            Job job = new Job(lock);
            job.start();
        }
        ThreadState.SleepUtil.second(1);
    }

    private static class Job extends Thread {
        private ReentrantLock2 lock;
        public Job(ReentrantLock2 lock) {
            this.lock = lock;
        }

        @Override
        public void run() {
            //连续两次打印当前线程，和等待队列中的线程
            lock.lock();
            try {
                System.out.print(Thread.currentThread().getName());
                printQueue((List<Thread>) lock.getQueuedThreads());

            }finally {
                lock.unlock();
            }

        }
    }

    private static void printQueue(List<Thread> arr) {
        System.out.println("waiting thread: ");
        for(Thread t : arr) {
            System.out.print(t.getName() + " > ");
        }
        System.out.println();
    }
}
