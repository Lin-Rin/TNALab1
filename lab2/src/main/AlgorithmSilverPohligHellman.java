package main;

import canonicaldistribution.CanonicalDistribution;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class AlgorithmSilverPohligHellman {

    public static long bruteForceSearch(long a, long b, long n) {
        var temp = 0L;

        for (int i = 0; i < n; i++) {
            temp = pow(a, i, n);
            if (temp == b) {
                return i;
            }
        }

        return 0;
    }

    private static long[] gcdExtended(long a, long b) {
        long r0 = b, r1 = a;
        long u0 = 0, u1 = 1; // ?? 01 ?? 10
        long v0 = 1, v1 = 0; // ?? 10 ?? 01

        while (r1 != 0) {
            var q = r0 / r1;

            var temp = r0;
            r0 = r1;
            r1 = temp - q * r1;

            temp = u0;
            u0 = u1;
            u1 = temp - q * u1;

            temp = v0;
            v0 = v1;
            v1 = temp - q * v1;
        }

        return new long[]{r0, u0, v0};
    }

    private static long inverse(long a, long b) {
        var gcd = gcdExtended(a, b);
        if (gcd[0] != 1) {
            throw new IllegalArgumentException("Inverse do not exist");
        }
        return gcd[1];
    }

    private static long inversePow(long a, long x, long n) {
        if (x == 0) {
            return 1;
        }
        var b = a;
        while (x < -1) {
            b = (b * a) % n;
            x = x + 1;
        }

        return inverse(b, n) % n;
    }

    private static long CRT(List<Long> y, List<Long> cannon) { // Chinese remainder theorem
        long res = 0;
        long N = cannon.stream().reduce(1L, (a, b) -> a * b);

        long[] Ni = new long[cannon.size()];
        long[] Mi = new long[cannon.size()];

        for (int i = 0; i < cannon.size(); i++) {
            Ni[i] = N / cannon.get(i);
            Mi[i] = inverse(Ni[i], cannon.get(i));
        }

        for (int i = 0; i < cannon.size(); i++) {
            res += y.get(i) * Ni[i] * Mi[i];
        }

        return res % N;
    }

    public static long algorithmSilverPohligHellman(long a, long b, long n) {
        long order = n - 1;
        List<Long> cannon = new ArrayList<>(CanonicalDistribution.getCanonicalDistributionList(order));
        List<Long> factors = cannon.stream()
                .distinct()
                .toList();
        List<Long> powers = new ArrayList<>(cannon.stream().collect(Collectors.groupingBy(Long::valueOf, Collectors.counting())).values());
        ArrayList<ArrayList<Long>> r = new ArrayList<>();

        cannon.clear();
        cannon = IntStream.range(0, powers.size())
                .mapToLong(i -> (long) Math.pow(factors.get(i), powers.get(i))).
                boxed().
                collect(Collectors.toList());

        for (long p : factors) {
            ArrayList<Long> rp = new ArrayList<>();

            for (int i = 0; i < p; i++) {
                long res = pow(a, ((order * i) / p), n);
                rp.add(res);
            }
            r.add(rp);
        }

        ArrayList<Long> Y = new ArrayList<>();

        for (int i = 0; i < factors.size(); i++) {
            var num = pow(b, order / factors.get(i), n);
            long xi = r.get(i).indexOf(num);
            long xPow = xi;

            for (int j = 1; j < powers.get(i); j++) {
                var temp1 = inversePow(a, -xPow, n) < 0 ? inversePow(a, -xPow, n) + n : inversePow(a, -xPow, n);
                var temp2 = (long) (order / (Math.pow(factors.get(i), j + 1)));

                num = pow(b * temp1, temp2, n);

                xi = r.get(i).indexOf(num);
                xPow = (long) ((xPow + xi * (Math.pow(factors.get(i), j))) % cannon.get(i));
            }

            Y.add(xPow);
        }

        var result = CRT(Y, cannon);
        return result < 0 ? result + n - 1 : result;
    }

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
}