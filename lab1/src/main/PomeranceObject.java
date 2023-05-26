package main;

import java.util.ArrayList;
import java.util.Arrays;

public class PomeranceObject {
    private final long a;
    private final long b;
    private final long difference;
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

        System.out.println(Arrays.toString(convertToVector(arr, base)));
    }

    public PomeranceObject(long x, long n, long m, long M, ArrayList<Long> pi) {
        this.a = x + m;
        this.b = (x + m) * (x + m) - n;
        long logB = (long) Math.log10(Math.abs(b));
        long whatWeSub = getLogSum(pi);
        difference = logB - whatWeSub;
    }

    private long getLogSum(ArrayList<Long> pi){
        long sum = 0;

        for(long l : pi){
            sum += Math.log10(l);
        }

        return sum;
    }

    public long getDifference() {
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

}
