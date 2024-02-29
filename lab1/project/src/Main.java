public class Main {


    private static void PrintMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void AddMatrix(int[][] m1, int[][] m2) {
        if (m1.length != m2.length || m1[0].length != m2[0].length) {
            System.out.println("Matricile nu au aceleasi dimensiuni!");
            return;
        }
        int[][] result = new int[m1.length][m1[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m1[i].length; j++) {
                result[i][j] = m1[i][j] + m2[i][j];
            }
        }
        PrintMatrix(result);
    }

    private static void MatrixProduct(int[][] m1, int[][] m2) {
        if (m1[0].length != m2.length) {
            System.out.println("Matricile nu au dimensiunile necesare pentru inmultire!");
            return;
        }
        int[][] result = new int[m1.length][m2[0].length];
        for (int i = 0; i < m1.length; i++) {
            for (int j = 0; j < m2[0].length; j++) {
                for (int k = 0; k < m1[0].length; k++) {
                    result[i][j] += m1[i][k] * m2[k][j];
                }
            }
        }
        PrintMatrix(result);
    }

    public static void main(String[] args) {

        /*
        //Ex 1
        ComplexNumber c1 = new ComplexNumber(2, 5);
        ComplexNumber c2 = new ComplexNumber(4, -1);
        ComplexNumber sum = c1.Add(c2);
        System.out.println("Sum: " + sum.GetReal() + " + " + sum.GetImaginary() + "i");

        //Ex 2
        int[][] m1 = {{2, 3, 1}, {7, 1, 6}, {9, 2, 4}};
        int[][] m2 = {{8, 5, 2}, {3, 9, 2}, {2, 7, 3}};
        AddMatrix(m1, m2);
        MatrixProduct(m1, m2);


        //Lab2
        FirSuma sf1 = new FirSuma(2);
        sf1.setPriority(10);
        FirSuma sf2 = new FirSuma(3);
        FirSuma sf3 = new FirSuma(4);
        sf1.start();
        sf2.start();
        sf3.start();
        try {
            sf1.join();
            sf2.join();
            sf3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Suma finala este: " + (sf1.sum + sf2.sum + sf3.sum));

        FirSumaRunnable sfr1 = new FirSumaRunnable(2);
        FirSumaRunnable sfr2 = new FirSumaRunnable(3);
        FirSumaRunnable sfr3 = new FirSumaRunnable(4);
        Thread t1 = new Thread(sfr1);
        Thread t2 = new Thread(sfr2);
        Thread t3 = new Thread(sfr3);

        t1.start();
        t2.start();
        t3.start();
        try {
            t1.join();
            t2.join();
            t3.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

*/
        //Sync
        Resursa res = new Resursa(3);
        FirSet fs = new FirSet(res);
        FirGet fg = new FirGet(res);
        fs.start();
        fg.start();
    }

}