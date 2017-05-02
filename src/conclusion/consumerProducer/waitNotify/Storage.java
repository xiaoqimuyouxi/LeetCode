package conclusion.consumerProducer.waitNotify;

import java.util.LinkedList;

/**
 * 仓库类Storage实现缓冲区
 * Created by ly on 2017/5/2.
 */
@SuppressWarnings("all")
public class Storage {
    private final int MAX_SIZE = 100;   //仓库最大存储量

    //仓库存储的载体（物质）
    private LinkedList<Object> list = new LinkedList<>();

    //生产num个产品
    public void produce(int num) {
        synchronized (list) {
            //仓库剩余容量不足时
            while (list.size() + num > MAX_SIZE) {
                System.out.println("要生产的产品数量：" + num + "\t库存量：" + list.size() + "\t暂时不能执行生产任务！");
                try {
                    //由于条件不满足，生产发生阻塞
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //生产条件满足下，生产num产品
            for (int i = 0; i < num; i++) {
                list.add(new Object());
            }
            System.out.println("已经生产产品数：" + num + "\t现仓储量为：" + list.size());

            list.notifyAll();
        }
    }

    //消费num个产品
    public void consume(int num) {
        synchronized (list) {
            //仓库中没有那么多的产品供消费
            while (list.size() < num) {
                System.out.println("要消费的产品数量：" + num + "\t库存量：" + list.size() + "\t暂时不能执行消费任务！");
                try {
                    //由于条件不满足，发生阻塞
                    list.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            //生产条件满足下，消费num的产品
            for (int i = 0; i < num; i++) {
                list.remove();
            }
            System.out.println("已经消费产品数：" + num + "\t现仓储量为：" + list.size());
            list.notifyAll();
        }
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
