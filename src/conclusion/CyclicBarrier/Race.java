package conclusion.CyclicBarrier;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * 负责屏障的初始化
 * Created by ly on 2017/4/10.
 */
public class Race {
    private CyclicBarrier cyclicBarrier = new CyclicBarrier(8); //设置到达屏障的线程数为8

    public void start() {
        List<Athlete> athleteList = new ArrayList<>();
        athleteList.add(new Athlete(cyclicBarrier, "tom"));
        athleteList.add(new Athlete(cyclicBarrier, "com"));
        athleteList.add(new Athlete(cyclicBarrier, "dog"));
        athleteList.add(new Athlete(cyclicBarrier, "thgf"));
        athleteList.add(new Athlete(cyclicBarrier, "saedwq"));
        athleteList.add(new Athlete(cyclicBarrier, "fwefer"));
        athleteList.add(new Athlete(cyclicBarrier, "adef"));
        athleteList.add(new Athlete(cyclicBarrier, "ojj"));

        Executor executor = Executors.newFixedThreadPool(8);   //创建拥有8个线程的线程池
        for (int i = 0; i < athleteList.size(); i++) {
            executor.execute(athleteList.get(i));
        }
    }

    public static void main(String[] args) {
        Race race = new Race();
        race.start();
    }
}
