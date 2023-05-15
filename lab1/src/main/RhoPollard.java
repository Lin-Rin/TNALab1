package main;

import java.util.ArrayList;

public class RhoPollard {

    public static long rhoPollard(long p) {
        long x = 2;
        long y= 2;
        long d = 1;


        return d;
    }

    private static long func(long n, long p) {
        return (n * n + 1) % p;
    }

    public static void main(String[] args) {
        long i = 123456787;
        long x = 2500744714570633849L;
        long[] longs = new long[]{
                15196946347083L,
                96267366284849L,
                61333127792637L,
                1021514194991569L,
                3009182572376191L,
                4000852962116741L, // 63252296
                499664789704823L,
                269322119833303L,
                679321846483919L,
                2485021628404193L
        };

        System.out.println(rhoPollard(i));
        System.out.println(rhoPollard(x));
        for (long l : longs) {
            long start = System.nanoTime();
            long res = rhoPollard(l);
            long end = System.nanoTime();
            System.out.println(res + " time - " + (end - start));
        }
    }
}