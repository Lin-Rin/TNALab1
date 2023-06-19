package canonicaldistribution;

import java.util.*;

public class CanonicalDistribution {

    private static final Long[] x = new Long[]{
            2L, 3L, 5L, 7L, 11L, 13L, 17L, 19L, 23L, 29L, 31L, 37L,
            41L, 43L, 47L, 53L, 59L, 61L, 67L, 71L, 73L, 79L, 83L, 89L, 97L
    };
    private final static List<Long> PRIMES = new ArrayList<>();

    static {
        Collections.addAll(PRIMES, x);
    }

    public static long[] getCanonicalDistribution(long n){
        if(isPrime(n)){
            System.out.println("prime");
            return new long[]{n};
        }
        ArrayList<Long> res = new ArrayList<>();

        var count = 0;
        while(count != PRIMES.size()){
            if(n % PRIMES.get(count) == 0){
               n = n / PRIMES.get(count);
               res.add(PRIMES.get(count));
            } else {
                count++;
            }
        }

        if(n==1){
            Collections.sort(res);
            return res.stream().mapToLong(Long::longValue).toArray();
        }

        while(!isPrime(n)) {
            var tempo = rhoPollard(n);
            n = n / tempo;
            res.add(tempo);
        }

        if(isPrime(n)){
            res.add(n);
        }

        Collections.sort(res);
        return res.stream().mapToLong(Long::longValue).toArray();
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(CanonicalDistribution.getCanonicalDistribution(2*2*3*23*41*96267366284849L)));
    }

    private static boolean isPrime(long p) {
        if (p % 2 == 0) {
            return false;
        }

        for (int k = 0; k < 1000; k++) {
            Random random = new Random();
            long x = random.nextLong(p);

            if (x == 0) {
                x++;
            }
            if (x == p) {
                x--;
            }

            if (gcd(p, x) > 1) {
                return false;
            }

            long jacobiRes = jacobi(x, p);
            if (jacobiRes < 0) {
                jacobiRes = p - 1;
            }

            if (jacobiRes != modPow(x, (p - 1) / 2, p)) {
                return false;
            }
        }
        return true;
    }
    private static long rhoPollard(long p) {
        long d;
        long x = 2;
        long y = 2;
        long k = 2;

        var prevX = x;
        var prevY = y;

        do {
            x = f(prevX, p);
            y = f(f(prevY, p), p);

            prevX = x;
            prevY = y;
            d = gcd(Math.abs(x - y), p);

            if (x == y) {
                x = ++k;
                y = x;
                d = 1;

                prevX = x;
                prevY = y;
            }
        } while (d == 1);

        return d;
    }
    private static long f(long n, long p) {
        return (n * n + 1) % p;
    }

    private static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        if (a == 0) {
            return b;
        }

        return gcd(b, a % b);
    }
    private static int jacobi(long a, long n) {
        if (a < 0 || n % 2 == 0)
            throw new IllegalArgumentException("Wrong argument: (a, n) -- (" + a + ", " + n + ")");
        if (a == 0)
            return 0;
        if (a == 1)
            return 1;

        int e = 0;
        int s = 0;

        while (a % 2 != 1) {
            e++;
            a = a / 2;
        }

        if (e % 2 == 0)
            s = 1;
        else {
            if (n % 8 == 1 || n % 8 == 7)
                s = 1;
            if (n % 8 == 3 || n % 8 == 5)
                s = -1;
        }

        if (n % 4 == 3 && a % 4 == 3)
            s *= -1;
        n = n % a;

        return a == 1 ? s : s * jacobi(n, a);
    }
    private static long modPow(long a, long e, long p) {
        long result = 1;
        a %= p;

        while (e > 0) {
            if (e % 2 == 1)
                result = (result * a) % p;
            a = (a * a) % p;
            e /= 2;
        }

        return result;
    }
}
