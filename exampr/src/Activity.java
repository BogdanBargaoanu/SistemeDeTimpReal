public class Activity {
    public int time;

    public Activity(int time) {
        this.time = time;
    }

    public void run() {
        for(int i=0; i<=time*10000; i++) {
            i++;
            i--;
        }
    }
}