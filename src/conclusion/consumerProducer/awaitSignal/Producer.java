package conclusion.consumerProducer.awaitSignal;

/**
 * 生产者类继承线程类
 * Created by ly on 2017/5/2.
 */
public class Producer extends Thread {
    private int num;    //每次生产的产品数
    private Storage storage;    //放置的仓库

    //构造函数，设置仓库
    public Producer(Storage storage) {
        this.storage = storage;
    }

    //run方法生产产品
    @Override
    public void run() {
        produce(num);
    }

    public void produce(int num) {
        storage.produce(num);
    }

    //get/set方法

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }
}
