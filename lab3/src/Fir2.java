import java.util.concurrent.Semaphore;

public class Fir2 extends Thread {
    int activity_max, activity_min, arcIesire, sleep;
    Semaphore s;

    Fir2(Semaphore sa, int sleep, int min_activity, int max_activity, int arcIesire) {
        this.sleep = sleep;
        this.activity_max = max_activity;
        this.activity_min = min_activity;
        this.s = sa;
        this.arcIesire = arcIesire;
    }

    public void run() {

        // while (true) {
        try {
            System.out.println(this.getName() + " - STATE 1");
            Thread.sleep(sleep * 1000);
            System.out.println(this.getName() + " - STATE 2");
            this.s.acquire(this.arcIesire);
            int k = (int) Math.round(Math.random() * (activity_max
                    - activity_min) + activity_min);
            for (int i = 0; i < k * 100000; i++) {
                i++;
                i--;
            }
            System.out.println(this.getName() + " - STATE 3");
            if (arcIesire == 2) {
                this.s.release();
            } else {
                this.s.release(2);
            }
            System.out.println(this.getName() + " - STATE 4");
        } catch (InterruptedException e) {
            e.printStackTrace();
            // }
        }
    }
}
