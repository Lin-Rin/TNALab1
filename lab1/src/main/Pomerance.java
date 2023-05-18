package main;

import java.util.*;

// TODO
// factorization
// solve
// that we will reduce/remain/...
// sieve
// final step

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
        System.out.println(Arrays.toString(new Pomerance().rishenny(78, 9, 3)));
    }

    public long[] rishenny(long n,long M, long pi) {
        var res = new ArrayList<Long>();
        long m = (long)Math.sqrt(n);
        long y=0; // y = x + m

        if (tool.jacobi(n,pi)==1){
            if((pi - 3) % 4 == 0) {
                y = (long) Math.pow(n, (pi + 1) / 4);
                res.add((long) (y - m) % pi);
                y = (long) Math.pow(-n, (pi + 1) / 4);
                res.add((long) (y - m) % pi);
                System.out.println("gg3232");
            }
        }

        long pMinusOne = pi - 1;
        long Q = pMinusOne;
        int s = 0;

        while (Q % 2 == 0) {
            Q /= 2;
            s++;
        }

        long z = 1;
        while (tool.jacobi(z,pi) != -1){
            z++;
        }

        long c = (long)Math.pow(z,Q) % pi;
        long R = (long)Math.pow(n,(Q+1)/2) % pi;
        long t = (long)Math.pow(n,Q) % pi;
        long M1 = s;

        while (t % pi != 1) {
            System.out.println("gg566hfdhfh");
            if (t % pi == 1){
                y = R;
                res.add((y-m));
                y = pi-R;
                res.add(y-m);

            }
            else{
                int i;
                for (i = 1; i < M; i++) {
                    if (Math.pow(t,Math.pow(2,i)) % pi == 1) {
                        break;
                    }
                }
                long b = (long)Math.pow(c,Math.pow(2,M1-i-1)) % pi;
                R = R*b % pi;
                t = t*b*b % pi;
                c = b*b % pi;
                M1 = i;
                System.out.println("gg566");
            }

        }
        return res.stream().mapToLong(Long::longValue).toArray();
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
