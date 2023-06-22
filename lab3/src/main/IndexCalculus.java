package main;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

public class IndexCalculus {

    private static ArrayList<ArrayList<Long>> preparation(long a, long n, ArrayList<Long> S) {
        throw new UnsupportedOperationException();
    }

    private static ArrayList<Long> solve() {
        throw new UnsupportedOperationException();
    }

    private static ArrayList<Long> factorBase() {
        throw new UnsupportedOperationException();
    }

    public static long algorithmIndexCalculus(long a, long b, long n) {
        long CONST = (long) ((long) 3.38 * Math.exp(0.5 * Math.pow(log2(n * log2(log2(n))), 0.5)));
        ArrayList<Long> S = factorBase();
        var temp = preparation(a, n, S);
        ArrayList<Long> K = temp.get(0);
        temp.remove(0);
        ArrayList<ArrayList<Long>> A = new ArrayList<>(temp);

        ArrayList<Long> x = solve();


        return 0;
    }


    // --------------------------- tools ---------------------------
    private static long pow(long base, long exp, long mod) {
        var res = 1L;

        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }

            base = (base * base) % mod;
            exp /= 2;
        }

        return res;
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        if (a == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

    private boolean isPrime(long p) {
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

    private int jacobi(long a, long n) {
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

    private long modPow(long a, long e, long p) {
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

    private static double log2(double num) {
        return Math.log(num) / Math.log(2);
    }

}