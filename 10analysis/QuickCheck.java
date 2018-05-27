import edu.princeton.cs.algs4.*;

public class QuickCheck {
    private static final double EULER_CONSTANT = 0.5772156649;

    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        double[] c = new double[maxN + 1];
        c[0] = 0;
        for (int N = 1; N <= maxN; N++)
            c[N] = (N + 1) * c[N - 1] / N + 2;

        for (int N = 10; N <= maxN; N *= 10) {
            double approx = 2 * (N + 1) * (Math.log(N) + EULER_CONSTANT) - 2 * N;
            StdOut.printf("%10d %15.2f %15.2f\n", N, c[N], approx);
        }
    }
}
