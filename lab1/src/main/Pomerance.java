package main;

import java.util.*;

// TODO
// factorization
// solve
// that we will reduce/remain/...
// sieve
// final step

public class Pomerance {

    private static final WheelFactorization wheel1 = new WheelFactorization();

    private final Tools tool = new Tools();
    private final SimplicityTest test = new SimplicityTest();

    private final static double A = 1 / Math.sqrt(2);

    public long pomeranceMethod(long n){
        long m = (long) Math.sqrt(n);
        ArrayList<Long> B = buildBase(n);
        long M = m; // rand?
        long a[] = calculateA(M, m);
        long b[] =calculateB(M, m, n);
        double logB[] = calculateLogB(b);


        return 0;
    }

    private List<Long> factorization(long n, ArrayList<Long> B) throws Exception {
        var res = new ArrayList<Long>();
        var wheel = new WheelFactorization();
        var base = B.stream().mapToLong(Long::longValue).toArray();

        if (n < 0) {
            n = Math.abs(n);
            res.add(-1L);
        }

        while (n > 1) {
            var d = wheel.trial(n, base);
            res.add(d);
            n = n / d;
        }

        var temp = res.get(res.size() - 1);
        if( !B.contains(temp) ){
            throw new Exception(temp + " do not factorize in factor base B");
        }
        return res;
    }

    public static void main(String[] args) throws Exception {
        List<Long> base1 = Arrays.asList(-1L, 2L, 3L, 5L, 7L, 13L);
        var base = new ArrayList<>(base1);
        System.out.println(new Pomerance().factorization(-2730, base));
    }

//    List<Long> base1 = Arrays.asList(-1L, 2L, 3L, 5L, 7L, 13L);
//    var base = new ArrayList<>(base1);
//    System.out.println(new Pomerance().factorization(-2730, base));

    public long[] rootmod(long n,long M, long pi) {
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

        long pOne = pi - 1;
        long Q = pOne;
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

    private ArrayList<Long> buildBase(long n) {
        var res = new TreeSet<Long>();
        var temp = new TreeSet<Long>();

        res = buildFactorBase(n);

        for (int i =0; i < 5; i++) {
            temp = buildFactorBase(n);
            res.addAll(temp);
        }

        // res.stream().mapToLong(Long::longValue).toArray();
        return new ArrayList<>(res);
    }
}
