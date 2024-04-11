import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier bariera = new CyclicBarrier(3, new Runnable() {

            public void run() {
                System.out.println("Rutina barierei");
            }
        });
        ReentrantLock l1 = new ReentrantLock();
        ReentrantLock l2 = new ReentrantLock();
        Fir1 fir1 = new Fir1(bariera,2,4,4,l1,null,1);
        Fir1 fir2 = new Fir1(bariera,3,6,3,l1,l2,2);
        Fir1 fir3 = new Fir1(bariera,2,5,5,l2,null,3);
        fir1.start();
        fir2.start();
        fir3.start();

    }
}