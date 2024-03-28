import java.util.concurrent.locks.Lock;

public class Fir1 extends Thread {
    Lock la1, la2;
    int sleep, activity_min, activity_max, activity_min2, activity_max2;
    public Fir1(Lock la1, Lock la2, int sleep, int activity_min, int activity_max, int activity_min2, int activity_max2) {
        this.la1 = la1;
        this.la2 = la2;
        this.sleep = sleep;
        this.activity_min = activity_min;
        this.activity_max = activity_max;
        this.activity_min2 = activity_min2;
        this.activity_max2 = activity_max2;
    }
    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        int k = (int) Math.round(Math.random() * (activity_max
                - activity_min) + activity_min);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        la1.lock();
        System.out.println(this.getName() + " - STATE 2");
        k = (int) Math.round(Math.random() * (activity_max2
                - activity_min2) + activity_min2);
        for (int i = 0; i < k * 100000; i++) {
            i++;
            i--;
        }
        try {
            state3();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        la1.unlock();
        la2.unlock();
        System.out.println(this.getName() + " - STATE 4");

    }
    public void state3() throws InterruptedException {
        if (la2.tryLock()) {
            System.out.println(this.getName() + " - STATE 3");
            try {
                Thread.sleep(sleep * 700);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println(this.getName() + " - STATE 3");
            la1.unlock();
            sleep(sleep * 1000);
            la1.lock();
            la2.lock();
        }
    }

}
