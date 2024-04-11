import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
       /* CyclicBarrier bariera = new CyclicBarrier(3, new Runnable() {

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

        CountDownLatch cdl = new CountDownLatch(3);
        Semaphore s1 = new Semaphore(0);
        Semaphore s2 = new Semaphore(0);
        Fir2 fir1 = new Fir2(cdl,2,3,7,s1,s2,1);
        Fir2 fir2 = new Fir2(cdl,3,5,5,s1,null,2);
        Fir2 fir3 = new Fir2(cdl,4,6,5,s2,null,3);
        fir1.start();
        fir2.start();
        fir3.start();
*/
        Exchanger<List<Integer>> exchanger = new Exchanger<>();
        Fir3 f1 = new Fir3(exchanger);
        Fir3 f2 = new Fir3(exchanger);
        f1.start();
        f2.start();
    }
}