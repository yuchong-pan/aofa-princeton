import edu.princeton.cs.algs4.*;

public class MergeLinearTerm implements Sequence {
    private final double[] c;

    public MergeLinearTerm(int maxN) {
        c = new double[maxN + 1];
        c[1] = 1;
        for (int N = 2; N <= maxN; N++)
            c[N] = c[N / 2] + c[N - N / 2] + N;
        for (int N = 2; N <= maxN; N++)
            c[N] -= N * Math.log(N) / Math.log(2) + N;
    }

    public double eval(int N) {
        return c[N];
    }

    public static void main(String[] args) {
        int maxN = Integer.parseInt(args[0]);
        MergeLinearTerm M = new MergeLinearTerm(maxN);
        Values.show(M, maxN);
    }
}
