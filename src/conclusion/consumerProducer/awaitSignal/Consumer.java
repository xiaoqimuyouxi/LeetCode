package conclusion.consumerProducer.awaitSignal;

/**
 * 消费者类继承线程
 * Created by ly on 2017/5/2.
 */
public class Consumer extends Thread {
    private int num;    //要消费的产品数
    private Storage storage;    //消费仓库

    public Consumer(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void run() {
        consume(num);
    }

    public void consume(int num) {
        storage.consume(num);
    }

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
