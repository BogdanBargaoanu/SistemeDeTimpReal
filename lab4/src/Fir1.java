import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Fir1 extends Thread{
    CyclicBarrier bariera;
    int activityMin;
    int activityMax;
    int sleep;
    ReentrantLock l1;
    ReentrantLock l2;
    int numarFir;

    public Fir1(CyclicBarrier bariera, int activityMin, int activityMax, int sleep, ReentrantLock l1, ReentrantLock l2, int numarFir) {
        this.activityMin = activityMin;
        this.activityMax = activityMax;
        this.sleep = sleep;
        this.bariera = bariera;
        this.l1 = l1;
        this.l2 = l2;
        this.numarFir = numarFir;
    }

    public void run() {
        if(numarFir == 1 || numarFir == 3) {
            System.out.println(this.getName() + " - STATE 1");
            l1.lock();
            System.out.print(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activityMax
                    - activityMin) + activityMin);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            try {
                Thread.sleep(sleep * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l1.unlock();
            System.out.println(this.getName() + " - STATE 3");
        }
        else {
            System.out.println(this.getName() + " - STATE 1");
            l1.lock();
            l2.lock();
            System.out.print(this.getName() + " - STATE 2");
            int k = (int) Math.round(Math.random() * (activityMax
                    - activityMin) + activityMin);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            try {
                Thread.sleep(sleep * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            l1.unlock();
            l2.unlock();
            System.out.println(this.getName() + " - STATE 3");
        }
        try {
            bariera.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

}
