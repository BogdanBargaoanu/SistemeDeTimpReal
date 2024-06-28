public class Main {
    public static void main(String[] args) {

        Acitivty act = new Activity(10);
        J1 j1 = new J1(act);
        j1.start();


        System.out.println("Hello world!");
    }
}