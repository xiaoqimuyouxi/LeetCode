package conclusion.CyclicBarrier;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * 8名运动员同时参加100米赛跑，只有当所有运动员就位好后比赛才能正式开始
 * Created by ly on 2017/4/10.
 */
public class Athlete implements Runnable {
    private CyclicBarrier cyclicBarrier;
    private String name;

    public Athlete(CyclicBarrier cyclicBarrier, String name) {
        this.cyclicBarrier = cyclicBarrier;
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(name + " 就位");
        try {
            cyclicBarrier.await();
            Random random = new Random();
            double time = (double)random.nextDouble()+9;
            System.out.println(name + " : " + time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }
}
