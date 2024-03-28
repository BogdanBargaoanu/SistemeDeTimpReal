import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) {
        Lock l = new ReentrantLock();
        Lock l2 = new ReentrantLock();
        /*
        Fir f1, f2;
        f1 = new Fir(1, l);
        f2 = new Fir(2, l);
        f1.start();
        f2.start();
        Fir1 f1, f2;
        f1 = new Fir1(l, l2, 4, 2, 4, 4, 6);
        f2 = new Fir1(l2, l, 5, 3, 5, 5, 7);
        f1.start();
        f2.start();
        Semaphore s = new Semaphore(1);
        Fir2 f1, f2;
        f1 = new Fir2(s, 2,2, 5, 2);
        f2 = new Fir2( s, 4, 3, 6, 1);
        f1.start();
        f2.start();
        */
        Semaphore s = new Semaphore(2);
        Fir3 f1, f2, f3;
        f1 = new Fir3(s, 4, 7,  2);
        f2 = new Fir3(s, 3, 6,  5);
        f3 = new Fir3(s, 5, 7,  6);
        f1.start();
        f2.start();
        f3.start();
    }
}