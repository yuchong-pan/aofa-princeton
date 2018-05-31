import edu.princeton.cs.algs4.*;

public class SqrtTwo implements Sequence {
    private final double[] c;

    public SqrtTwo(int maxN) {
        c = new double[maxN + 1];
        c[0] = 1;
        for (int N = 1; N <= maxN; N++) {
            c[N] = (c[N - 1] + 2 / c[N - 1]) / 2;
        }
    }

    public double eval(int N) {
        return c[N];
    }

    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        SqrtTwo test = new SqrtTwo(maxN);
        for (int i = 0; i <= maxN; i++) {
            StdOut.println(test.eval(i));
        }
    }
}
