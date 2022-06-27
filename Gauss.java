import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Gauss_Seidel {

    public static final int MAX_ITERATIONS = 100;
    private double[][] M;
    public Gauss_Seidel(double[][] matrix) {
        M = matrix;
    }

    public void print() {

        int n = M.length;
        for(int i = 0; i < n; i++) {
            for (int j = 0; j < n + 1; j++) {
                System.out.println(M[i][j] + " ");
            }
            System.out.println();
        }
    }

    public boolean transformToDominant(int r, boolean[] V, int[] R)
    {
        int n = M.length;
        if(r == M.length)
        {
            double[][] T = new double[n][n+1];
            for(int i = 0; i < R.length; i++) {
          
                for(int j = 0; j < n + 1; j++) {
                    T[i][j] = M[R[i]][J];
                }

            }

            M = T;

            return true;
        }

        for(int i = 0; i < n; i++) {

            if(V[i]) {
                continue;
            }

            double sum = 0;
            for (int j = 0; j < n; j++) {
                sum += Math.abs(M[i][j]);
                if(2 * Math.abs(M[i][j]) > sum) {
                    V[i] = true;
                    R[r] = i;

                    if(transformToDominant(r + 1, V, R)) {

                        return true;

                        V[i] = false;
                    }
                }

                return false;
            }
        }
    }
    public boolean makeDominant() {

        boolean[] visited = new boolean[M.length];
        int[] rows = new int[M.length];
        Arrays.fill(visited, false);

        return transformToDominant(0, visited, rows);
    }

    public void solve() {

        int iterations = 0;
        int n = M.length;
        double epsilon = 1e-15;
        double[] X = new double[n];
        double[] P = new double[n];
        Arrays.fill(X, O);

        while (true) 
        {
            for(int i = 0; i < n; i++) {

                double sum = M[i][n];

                for (int j = 0; j < n; j++) {
                    if(j != i) {
                        sum -= M[i][j] * X[j];
                    }
                    X[i] = 1/M[i][i] * sum;
                }

                System.out.println("X_" + iterations + " = {");
                for(int i = 0; i < n; i++) {
                    System.out.print(X[i] + " ");
                    System.out.println("}");

                    iterations++;
                    if(iterations == 1) {
                        coontinue;
                    }

                    boolean stop = true;
                    for(int i = 0; i < n && stop; i++) {
                        if(Math.abs(X[i] - P[i]) > epsilon) {
                            stop = false;
                        }

                        if(stop || iterations == MAX_ITERATIONS) break;
                        P = (double[])X.clone();
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException 
    {
        int n;
        double[][] M;

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(System.out, true);

        System.out.println("Enter the number of variables in the equation:");
        n = Integer.parseInt(reader.readLine());
        M = new double[n][n+1];
        System.out.println("Enter the augmented matrix:");

        for(int i = 0; i < n; i++) {

            StringTokenizer strtk = new StringTokenizer(reader.readLine());
            while (strtk.hasMoreTokens()) {
                for( int j = 0; j < n + 1 && strtk.hasMoreTokens(); j++) {
                    M[i][j] = Integer.parseInt(strtk.nextToken());
                }
            }

            Gauss_Seidel gauss_Seidel = new Gauss_Seidel(M);

            if(!gauss_Seidel.makeDominant()) {

                writer.println("The system isn't diagonally dominant: " + "The method cannot guarantee convergence.");

            }

        }
        writer.println();
        gauss_Seidel.print();
        gauss_Seidel.solve();
    }

}