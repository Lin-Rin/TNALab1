package main;

import java.util.*;

public class Pomerance {

    private final Tools tool = new Tools();
    private final SimplicityTest test = new SimplicityTest();

    private final static double A = 1 / Math.sqrt(2);

    public long pomeranceMethod(long n){
        long m = (long) Math.sqrt(n);
        long[] B = buildBase(n);
        long M = m; // rand?
        long a[] = calculateA(M, m);
        long b[] =calculateB(M, m, n);
        double logB[] = calculateLogB(b);


        return 0;
    }

    private List<Long> factorization(long n, long[] base){
        var res = new ArrayList<Long>();
        var wheel = new WheelFactorization();

        if (n < 0) {
            n = Math.abs(n);
            res.add(-1L);
        }

        System.out.println(n);

        var d = 0L;
        while (n > 1){
            d = wheel.trial(n, base);
            System.out.println(d);
            res.add(d);
            n = n / d;
        }

        return res;
    }

    public static void main(String[] args) {
        long[] base = new long[]{-1, 2, 3};
        System.out.println(new Pomerance().factorization(72, base));
    }

    /**
     q(x) = 0 mod(pi)
     (x + m)^2 = n mod pi
     ?n/pi == 1? jacobi, !=1 skip
     find x
     next for each xi: xi + kn from [-M, M]

     solve all mod
     return array x1, x1+p, ...
     **/
    public long[] solve(){
        throw new UnsupportedOperationException();
    }

    private long[] calculateA(long x, long m){
        var res = new ArrayList<Long>();

        for(long i = -x; i <= x; i++){
            res.add(i + m);
        }

        return res.stream().mapToLong(Long::longValue).toArray();
    }

    private long[] calculateB(long x, long m, long n){
        var res = new ArrayList<Long>();

        for(long i = -x; i <= x; i++){
            res.add((long) Math.pow(i + m, 2) - n);
        }

        return res.stream().mapToLong(Long::longValue).toArray();
    }

    private double[] calculateLogB(long[] b){
        var res = new ArrayList<Double>();

        for (long i : b) {
            res.add(Math.log10(Math.abs(i)));
        }

        return res.stream().mapToDouble(Double::doubleValue).toArray();
    }

    private static long getL(long n, double a){
        return (long) Math.pow(Math.exp(Math.sqrt(log2(n) * log2(n))), a);
    }

    private static double log2(double num){
        return Math.log(num) / Math.log(2);
    }

    private TreeSet<Long> buildFactorBase(long n){
        var res = new TreeSet<Long>();
        res.add(-1L);
        long L = getL(n, A);

        for (long i = 2; i < L; i++) {
            if(test.isPrime(i)){
                if(tool.jacobi(n, i) == 1){
                    res.add(i);
                }
            }
        }

        return res;
    }

    private long[] buildBase(long n) {
        var res = new TreeSet<Long>();
        var temp = new TreeSet<Long>();

        res = buildFactorBase(n);

        for (int i =0; i < 5; i++) {
            temp = buildFactorBase(n);
            res.addAll(temp);
        }

        return res.stream().mapToLong(Long::longValue).toArray();
    }
}
