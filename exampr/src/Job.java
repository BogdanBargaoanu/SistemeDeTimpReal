public class Job extends Thread{
    public Activity activity;

    public Job(Activity activity) {
        this.activity = activity;
    }
    public void start() {
        this.activity.run();
        System.out.println("Job finished");
        }
    }
}