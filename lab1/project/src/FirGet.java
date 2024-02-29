public class FirGet extends Thread {
    public Resursa res;

    public FirGet(Resursa res) {
        this.res = res;
    }

    @Override
    public void run() {
        for (int i = 1; i <= 10; i++) {
            System.out.println("FirGet - Am citit: " + res.GetR());
        }
    }
}
