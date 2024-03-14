public class ExecutionThread2 extends Thread {
    Integer monitor;
    Integer monitor2;

    int activity_min2, activity_max2, activity_min, activity_max, sleep;

    public ExecutionThread2(Integer monitor, Integer monitor2, int activity_min, int activity_max, int activity_min2, int activity_max2, int sleep) {

        this.monitor = monitor;

        this.monitor2 = monitor2;

        this.activity_min = activity_min;

        this.activity_max = activity_max;

        this.activity_min2 = activity_min2;

        this.activity_max2 = activity_max2;

        this.sleep = sleep;


    }

    public void run() {

        System.out.println(this.getName() + " - STATE 1");

        synchronized (monitor) {


            System.out.println(this.getName() + " - STATE 2");

            int k = (int) Math.round(Math.random() * (activity_max

                    - activity_min) + activity_min);

            for (int i = 0; i < k * 100000; i++) {

                i++;
                i--;

            }

            synchronized (monitor2) {
                System.out.println(this.getName() + " - STATE 3");

                int k2 = (int) Math.round(Math.random() * (activity_max2

                        - activity_min2) + activity_min2);

                for (int i = 0; i < k2 * 100000; i++) {

                    i++;
                    i--;

                }

                try {
                    Thread.sleep(this.sleep*1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        System.out.println(this.getName() + " - STATE 4");
    }
}
