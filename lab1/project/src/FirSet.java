public class FirSet extends Thread {
    public Resursa res;

    public FirSet(Resursa res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {

            res.SetR(i);
            System.out.println("FirSet - Am scris: " + i);
        }
    }
}
