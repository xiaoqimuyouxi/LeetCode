package conclusion.consumerProducer.awaitSignal;

import java.util.LinkedList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 仓库类，实现产品的生产与消费
 * Created by ly on 2017/5/2.
 */
@SuppressWarnings("all")
public class Storage {
    private final int MAX_SIZE = 100;   //仓库最大存储量

    //仓库存储物质载体
    private LinkedList<Object> list = new LinkedList<>();

    //锁
    private Lock lock = new ReentrantLock();

    //仓库满的条件
    Condition full = lock.newCondition();

    //仓库空的条件
    Condition empty = lock.newCondition();

    //生产产品
    public void produce(int num) {
        //获得锁
        lock.lock();

        //如果仓库容量不足
        while (list.size() + num > MAX_SIZE) {
            System.out.println("要生产的产品数量：" + num + "\t库存量：" + list.size() + "\t暂时不能执行生产任务！");
            try {
                //由于条件不满足，生产发生阻塞
                full.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //生产条件满足下，生产num产品
        for (int i = 0; i < num; i++) {
            list.add(new Object());
        }
        System.out.println("已经生产产品数：" + num + "\t现仓储量为：" + list.size());

        full.signalAll();
        empty.signalAll();

        lock.unlock();  //释放锁
    }

    //消费产品
    public void consume(int num) {
        lock.lock();

        //仓库中没有那么多的产品供消费
        while (list.size() < num) {
            System.out.println("要消费的产品数量：" + num + "\t库存量：" + list.size() + "\t暂时不能执行消费任务！");
            try {
                //由于条件不满足，发生阻塞
                empty.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //生产条件满足下，消费num的产品
        for (int i = 0; i < num; i++) {
            list.remove();
        }
        System.out.println("已经消费产品数：" + num + "\t现仓储量为：" + list.size());

        empty.signalAll();
        full.signalAll();

        lock.unlock();
    }

    //get/set方法
    public LinkedList<Object> getList() {
        return list;
    }

    public void setList(LinkedList<Object> list) {
        this.list = list;
    }

    public int getMAX_SIZE() {
        return MAX_SIZE;
    }
}
