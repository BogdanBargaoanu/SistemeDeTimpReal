public class FirSumaRunnable implements Runnable{
    private int p;
    public int sum = 0;

    public FirSumaRunnable(int p) {
        this.p = p;
    }

    @Override
    public void run() {
        for (int i = 0; i < 60; i += p) {
            this.sum += i;
        }
        System.out.println("Suma este: " + this.sum + " pentru firul " + Thread.currentThread().getName() + " cu prioritatea " + Thread.currentThread().getPriority());
    }
}
