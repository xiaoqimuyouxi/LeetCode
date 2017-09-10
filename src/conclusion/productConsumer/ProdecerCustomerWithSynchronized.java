package conclusion.productConsumer;


import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * Created by ly on 2017/9/4.
 */
public class ProdecerCustomerWithSynchronized {
    Executor pool = Executors.newFixedThreadPool(10);
    //仓库
    private LinkedList<String> storageList = new LinkedList<>();

    //仓库容量
    private int MAX_SIZE = 3;
    //仓库为空
    private int ZERO = 0;
    //生产者线程
    private class producer implements Runnable {
        private void produce() {
            synchronized (storageList) {
                System.out.println(Thread.currentThread().getName() + "进入仓库，准备生产！");
                try {
                    if(storageList.size() == MAX_SIZE) {
                        System.out.println("仓库已满，等待消费者线程");
                        Thread.sleep(1000);
                        storageList.wait(); //当前线程放弃锁，处于等待状态，让消费者线程执行
                    }
                    if(storageList.size() < MAX_SIZE) {
                        String name = "产品 " + new Random().nextInt();
                        storageList.add(name);
                        System.out.println(Thread.currentThread().getName() + "往仓库中添加了一个产品！");
                    }
                    Thread.sleep(1000);
                    storageList.notifyAll();
                }catch (InterruptedException e) {
                    System.out.println("中断异常！");
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            while (true) {
                produce();
            }
        }
    }

    //消费者线程
    private class Consumer implements Runnable {
        private void consume() {
            synchronized (storageList) {
                System.out.println(Thread.currentThread().getName() + " 进入仓库，准备消费");
                try {
                    if(storageList.size() == ZERO) {
                        System.out.println("仓库已空，等待生产者生产！");
                        Thread.sleep(1000);
                        storageList.wait();
                    }
                    else {
                        System.out.println(Thread.currentThread().getName() + "从仓库取得产品" + storageList.removeFirst());
                    }
                    Thread.sleep(1000);
                    storageList.notifyAll();    //当前线程放弃锁，唤醒其他线程
                }catch (InterruptedException e) {
                    System.out.println("中断异常");
                    e.printStackTrace();
                }
            }
        }

        @Override
        public void run() {
            while (true) {
                consume();
            }
        }
    }

    //启动生产者和消费者线程
    public void start() {
        for (int i = 0; i < 5; i++) {
            pool.execute(new producer());
            pool.execute(new Consumer());
        }
    }

    public static void main(String[] args) {
        ProdecerCustomerWithSynchronized pc = new ProdecerCustomerWithSynchronized();
        pc.start();
    }
}
