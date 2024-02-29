public class Resursa {
    public int r = 0;

    public Resursa(int r) {
        this.r = r;
    }

    public synchronized void SetR(int r) {
        this.r = r;
        try {
            notify();
            wait(500);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    public synchronized int GetR() {
        try {
            wait(500);
            notify();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return this.r;
    }
}
