import java.util.concurrent.Semaphore;

class Fir3 extends Thread {
    int activity_max, activity_min, sleep;
    Semaphore s;

    Fir3(Semaphore sa, int min_activity, int max_activity, int sleep) {
        this.activity_max = max_activity;
        this.activity_min = min_activity;
        this.s = sa;
        this.sleep = sleep;
    }

    public void run() {
        while (true) {
            try {
                System.out.println(this.getName() + " - STATE 1");
                this.s.acquire();
                System.out.println(this.getName() + " - STATE 2");
                int k = (int) Math.round(Math.random() * (activity_max
                        - activity_min) + activity_min);
                for (int i = 0; i < k * 100000; i++) {
                    i++;
                    i--;
                }
                this.s.release();
                System.out.println(this.getName() + " - STATE 3");
                this.sleep(sleep * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.getName() + " - STATE 4");
        }
    }
}
