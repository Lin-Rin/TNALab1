package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RhoPollard {

    private Tools tool = new Tools();

    public long rhoPollard(long p) {
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
            d = tool.gcd(Math.abs(x - y), p);

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

    public static void main(String[] args) {
        RhoPollard rhoPollard = new RhoPollard();
        long i = 1021514194991569L;

        try {
            long start = System.nanoTime();
            long res = rhoPollard.rhoPollard(i);
            long end = System.nanoTime();
            System.out.println("result is - " + res + " time - " + (end - start));
            var t = i / res;
            System.out.println(t*res);
            System.out.println(i);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}