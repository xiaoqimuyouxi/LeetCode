package conclusion.factory;

/**
 * Created by ly on 2017/4/9.
 */
public class Test {
    public static void main(String[] args) {
//        Car car = Driver.driveCar("奥迪");
//        car.drive();

        CarManager ma = (CarManager)new AudiDriver();
        Car car = ma.driveCar();
        car.drive();
    }
}
