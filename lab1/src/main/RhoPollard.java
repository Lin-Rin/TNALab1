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

    public static void main(String[] args) {
        long i = 123456787L;
        long x = 2500744714570633849L;
        long[] longs = new long[]{
                3009182572376191L, // ok

                //1021514194991569L,

                4000852962116741L, // ok // 63252296
                15196946347083L, // ok
                499664789704823L, // ok
                269322119833303L, // ok
                679321846483919L, // ok
                96267366284849L, // ok
                61333127792637L, // ok
                2485021628404193L // ok

                , 1021514194991569L // inf time, need new start value
        };

        try {

            System.out.println(rhoPollard(i));
            System.out.println(rhoPollard(x));
            for (long l : longs) {
                long start = System.nanoTime();
                long res = rhoPollard(l);
                long end = System.nanoTime();
                System.out.println(res + " time - " + (end - start));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}