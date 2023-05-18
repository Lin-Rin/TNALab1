package main;

import java.util.Random;

public class RhoPollard {

    public static long rhoPollard(long p) {
        long x = 2;
        long y = 2;
        long d = 1;

        var prevX = x;
        var prevY = y;

        do {
            x = f(prevX, p);
            y = f(f(prevY, p), p);

            prevX = x;
            prevY = y;

            d = Tools.gcd(Math.abs(x - y), p);

            if (x == y) {
                x = new Random().nextLong() % p;
                y = x;
                d = 1;
            }
        } while (d == 1);

        return d;
    }

    private static long f(long n, long p) {
        return (n * n + 1) % p;
    }

}