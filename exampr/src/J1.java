public class J1 extends Job {
    public J1(Activity activity) {
        this.activity = activity;
    }

    public void start() {
        this.activity.run();
        System.out.println("Job finished");
    }
}
}