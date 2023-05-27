package main;

import java.util.ArrayList;
import java.util.Arrays;

public class PomeranceObject {
    private final long a;
    private final long b;
    private final double difference;
    private long[] factor;

    public static long[] convertToVector(long[] factor, long[] B) {
        long[] count = new long[B.length];

        for (long j : factor) {
            int i = Arrays.binarySearch(B, j);
            if (i >= 0) {
                count[i]++;
            }
        }

        for(int i = 0; i < count.length; i++){
            count[i] %= 2;
        }

        return count;
    }

    public static void main(String[] args) {
        long[] arr = {-1, 2,2,2,5,7};
        long[] base = {-1, 2, 3, 5, 7, 11};

        ArrayList<Long> tempo = new ArrayList<>();
        tempo.add(2L);
        tempo.add(3L);
        tempo.add(5L);
        //System.out.println(new PomeranceObject(2, 91, 9, -5, tempo));
    }

    public PomeranceObject(long x, long n, long m, long M, ArrayList<Long> pi) {
        this.a = x + m;
        this.b = (x + m) * (x + m) - n;
        double logB = Math.floor(Math.log10(Math.abs(b)) * 1000) / 1000;
        var that    = Math.floor(pi.stream().mapToDouble(Math::log10).sum() * 1000) / 1000;
        difference = logB - that;

        System.out.println(x + " " + pi);
    }

    public double getDifference() {
        return difference;
    }

    public long getA() {
        return a;
    }

    public long getB() {
        return b;
    }

    public void setFactor(long[] factor) {
        this.factor = factor;
    }

    public long[] getVector(long[] base) {
        return convertToVector(factor, base);
    }

    @Override
    public String toString() {
        return "{" +
                "a=" + a +
                ", b=" + b +
                ", difference=" + difference +
                ", factor=" + Arrays.toString(factor) +
                '}';
    }
}
