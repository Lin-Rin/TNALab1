package main;

import java.util.Arrays;

//TODO
// ???  factorization
// DONE bruteforce
// algorithm

// КТО
// gcdExtended
// invpow + inv

public class Main {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(gcdExtended(65, 395)));
    }

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

        return new long[] { r0, u0, v0 };
    }

}