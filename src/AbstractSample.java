/**
 * Created by ly on 2017/9/18.
 */
public abstract class AbstractSample {
    int g = 9;
    void set(){};

    void set(int j) {
        this.g = j;
    }

    abstract void get();

}
