package conclusion.factory;

/**
 * 抽象类的具体实现,,,,,类比于不同的产品
 *      奥迪车
 * Created by ly on 2017/4/9.
 */
public class Audi implements Car {
    public Audi() {

    }

    @Override
    public void drive() {
        System.out.println("奥迪车");
    }
}
