import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Exchanger;

public class Fir3 extends Thread {
    List<Integer> list = new ArrayList<Integer>();
    Exchanger<List<Integer>> ex = new Exchanger<List<Integer>>();

    public Fir3(Exchanger<List<Integer>> ex) {
        this.ex = ex;
    }

    public void run() {
        for (int i = 0; i < 3; i++) {
            int randElement = (int) Math.round(Math.random() * 100);
            list.add(randElement);
        }
        for (int i = 0; i < 3; i++) {
            System.out.print(this.getName() + " - " + list.get(i) + " ");
        }
        try {
            Thread.sleep(1000);
            this.list = ex.exchange(list);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(" ");
        for (int i = 0; i < 3; i++) {
            System.out.print(this.getName() + " - " + list.get(i) + " ");
        }
    }
}
