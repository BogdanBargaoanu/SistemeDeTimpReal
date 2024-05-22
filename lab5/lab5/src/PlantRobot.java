import java.util.concurrent.Semaphore;

public class PlantRobot extends Thread {
    Pcmd pcmd;
    Ppoz ppoz;
    Pmov pmov;
    PpozPlant ppozplant;

    public PlantRobot(Pcmd pcmd, PpozPlant ppozplant) {
        this.pcmd = pcmd;
        this.ppozplant = ppozplant;
        ppoz = new Ppoz();
        pmov = new Pmov();
    }

    public void run() {
        while (true) {
// jeton in ppoz;
            pcmd.waitForToken(); // grd for t1
            pmov.x = ppoz.x + pcmd.cmd;
            System.out.println("s-a executat t1, se misca spre " + pmov.x);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
            }
            ppoz.x = pmov.x;
            ppozplant.setPoz(pmov.x);
            System.out.println("s-a executat t2,am ajuns in " + ppoz.x);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Pcmd pcmd = new Pcmd();
        PpozPlant ppozplant = new PpozPlant();
        PlantRobot p = new PlantRobot(pcmd, ppozplant);
        p.start();
        Thread.sleep(7000);
        pcmd.setCmd(1);
        ppozplant.waitForToken();
        System.out.println("am vazut ca plantul a ajuns in " + ppozplant.x);
        Thread.sleep(500);
        pcmd.setCmd(-1);
    }
}

class Pcmd {
    Semaphore s = new Semaphore(0);
    int cmd; // poate avea valori -1, 0, 1

    public void waitForToken() {
        try {
            s.acquire();
        } catch (InterruptedException e) {
        }
    }

    public void setCmd(int cmd) {
        this.cmd = cmd;
        s.release(); // !!!
    }
}

class Ppoz {
    int x;
}

class Pmov {
    int x;
}

class PpozPlant {
    Semaphore s = new Semaphore(0);
    int x;

    public void waitForToken() {
        try {
            s.acquire();
        } catch (InterruptedException e) {
        }
    }

    public void setPoz(int poz) {
        this.x = poz;
        s.release(); // !!!
    }
}
