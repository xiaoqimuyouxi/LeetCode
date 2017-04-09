package conclusion.factory;

/**
 * Created by ly on 2017/4/9.
 */
public class BenzDriver implements CarManager {
    @Override
    public Car driveCar() {
        return new Benz();
    }
}
