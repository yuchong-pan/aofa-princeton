import edu.princeton.cs.algs4.*;

public class Merge {
    private static int INFTY = Integer.MAX_VALUE;

    public static void mergesort(int[] a, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        mergesort(a, lo, mid);
        mergesort(a, mid + 1, hi);
        int[] b = new int[mid - lo + 2];
        int[] c = new int[hi - mid + 1];
        for (int k = lo; k <= mid; k++)
            b[k - lo] = a[k];
        for (int k = mid + 1; k <= hi; k++)
            c[k - mid - 1] = a[k];
        b[mid - lo + 1] = INFTY;
        c[hi - mid] = INFTY;
        int i = 0, j = 0;
        for (int k = lo; k <= hi; k++)
            if (c[j] < b[i]) a[k] = c[j++];
            else a[k] = b[i++];
    }

    public static void main(String[] args) {
        int[] a = StdIn.readAllInts();
        mergesort(a, 0, a.length - 1);
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }
}
