import java.util.concurrent.locks.Lock;

public class Fir extends Thread {
    int nume;

    Lock l;

    Fir(int n, Lock la) {

        this.nume = n;

        this.l = la;

    }

    public void run() {

        this.l.lock();

        System.out.println("Fir " + nume + " a pus zavorul");

        regiuneCritica();

        this.l.unlock();

        System.out.println("Fir " + nume + " a eliberat zavorul");

    }

    public void regiuneCritica() {

        System.out.println("SE EXECUTA REGIUNEA CRITICA!");

        try {

            Thread.sleep(3000);

        } catch (InterruptedException e) {

            e.printStackTrace();

        }

    }
}
