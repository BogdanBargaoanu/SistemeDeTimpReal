public class FirSuma extends Thread {

    private int p;
    public int sum = 0;

    public FirSuma(int p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 0; i < 60; i += p) {
            this.sum += i;
        }
        System.out.println("Suma este: " + this.sum + " pentru firul " + this.getName() + " cu prioritatea " + this.getPriority());
    }


}
