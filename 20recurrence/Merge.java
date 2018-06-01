import edu.princeton.cs.algs4.*;

public class Merge {
    private static void merge(Comparable[] a, Comparable[] aux, int lo, int mid, int hi) {
        int i = lo, j = mid + 1, k = lo;
        while (i <= mid || j <= hi) {
            if (j > hi || (i <= mid && less(a[i],a[j])))
                aux[k++] = a[i++];
            else aux[k++] = a[j++];
        }
        for (k = lo; k <= hi; k++)
            a[k] = aux[k];
    }

    public static void sort(Comparable[] a, Comparable[] aux, int lo, int hi) {
        if (hi <= lo) return;
        int mid = lo + (hi - lo) / 2;
        sort(a, aux, lo, mid);
        sort(a, aux, mid + 1, hi);
        merge(a, aux, lo, mid, hi);
    }

    private static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void main(String[] args) {
        int[] input = StdIn.readAllInts();
        Integer[] a = new Integer[input.length];
        Integer[] aux = new Integer[input.length];
        for (int i = 0; i < a.length; i++)
            a[i] = input[i];
        sort(a, aux, 0, a.length - 1);
        for (int i = 0; i < a.length; i++)
            StdOut.println(a[i]);
    }
}
