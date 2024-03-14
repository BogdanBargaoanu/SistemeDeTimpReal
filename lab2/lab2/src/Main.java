import com.sun.source.tree.NewArrayTree;

public class Main {
    public static void main(String[] args) {
        Integer monitor = Integer.valueOf(1);
        Integer monitor2 = Integer.valueOf(1);

        // new ExecutionThread(monitor, 2, 4, 3, 6).start();

        //new ExecutionThread(monitor, 3, 5, 4, 7).start();

       // new ExecutionThread(monitor, 2, 4, 4, 4).start();
       // new ExecutionThread1(monitor, monitor2, 3, 6, 3, 3).start();
      //  new ExecutionThread(monitor2, 2, 5, 5, 5).start();

        ExecutionThread2 t1 = new ExecutionThread2(monitor, monitor2, 2, 4, 4, 6, 5);
        ExecutionThread2 t2 = new ExecutionThread2(monitor2, monitor, 3, 5, 5, 7, 4);
        t1.start();
        t2.start();

    }
}