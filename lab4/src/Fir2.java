import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Fir2 extends Thread {
    CountDownLatch cdl;
    int activityMin;
    int activityMax;
    int sleep;
    Semaphore s1;
    Semaphore s2;
    int numarFir;

    public Fir2(CountDownLatch cdl, int activityMin, int activityMax, int sleep, Semaphore s1, Semaphore s2, int numarFir) {
        this.activityMin = activityMin;
        this.activityMax = activityMax;
        this.sleep = sleep;
        this.cdl = cdl;
        this.s1 = s1;
        this.s2 = s2;
        this.numarFir = numarFir;
    }

    public void run() {
        System.out.println(this.getName() + " - STATE 1");
        if (numarFir == 1) {
            try {
                Thread.sleep(sleep * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activityMax
                    - activityMin) + activityMin);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            s1.release();
            s2.release();
        } else {
            try {
                s1.acquire();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            try {
                Thread.sleep(sleep * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activityMax
                    - activityMin) + activityMin);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
        }
        System.out.println(this.getName() + " - STATE 3");
        cdl.countDown();
        try {
            cdl.await();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
