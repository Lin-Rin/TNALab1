package main;

import canonicaldistribution.CanonicalDistribution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

//TODO
// DONE factorization
// DONE bruteforce
// algorithm

// КТО
// DONE gcdExtended
// DONE invPow + inv

public class Main {

    public static int bruteForceSearch(int a, int b, int n) {
        var temp = 0;

        for (int i = 0; i < n; i++) {
            temp = (int) Math.pow(a, i) % n;
            if (temp == b) {
                return i;
            }
        }

        return 0;
    }

    public static long[] gcdExtended(long a, long b) {
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

    public static long inverse(long a, long b) {
        var gcd = gcdExtended(a, b);
        if (gcd[0] != 1) {
            throw new IllegalArgumentException("Inverse do not exist");
        }
        return gcd[1];
    }

    public static long inversePow(long a, long x, long n) {
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

    public static long CRT() { // Chinese remainder theorem
        long res = 0;
        //  ????
        return res;
    }

    public static long algorithmSilverPohligHellman(long a, long b, long n) {
        long order = n - 1;
        List<Long> cannon = new ArrayList<>(CanonicalDistribution.getCanonicalDistributionList(order));
        List<Long> factors = cannon.stream()
                .distinct()
                .collect(Collectors.toList());
        List<Long> powers = new ArrayList<>(cannon.stream().collect(Collectors.groupingBy(Long::valueOf, Collectors.counting())).values());
        ArrayList<Long> r = new ArrayList<>();

        System.out.println(cannon);

        cannon.clear();
        cannon = IntStream.range(0, powers.size())
                .mapToLong(i -> (long) Math.pow(factors.get(i), powers.get(i))).boxed().collect(Collectors.toList());

        System.out.println(factors);
        System.out.println(powers);
        System.out.println(cannon);
        System.out.println(r);


        return CRT();
    }

    public static void main(String[] args) {
        var q = 1009;

        algorithmSilverPohligHellman(0, 1, q);
    }

}