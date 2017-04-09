package conclusion.factory;

/**
 * 简单工厂模式
 * 工厂类
 *      如果引入许多新的产品（car），那么会一直在这个类里面加判断
 * Created by ly on 2017/4/9.
 */
public class Driver {
    public static Car driveCar(String carName) {
        if(carName.equals("奥迪")) {
            return new Audi();
        }
        else if(carName.equals("奔驰")) {
            return new Benz();
        }
        return null;
    }
}
