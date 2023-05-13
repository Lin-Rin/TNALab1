package main;

import java.util.ArrayList;

public class RhoPollard {

    public static long rhoPollard(long n) {
        ArrayList<Long> xs = new ArrayList<>();
        ArrayList<Long> ys = new ArrayList<>();

        long x = 2;
        long y = 2;
        long d = 1;

        xs.add(x);
        ys.add(y);

        while (d == 1) {
            x = func(xs.get(xs.size() - 1), n);
            y = func(ys.get(ys.size() - 1), n);

            xs.add(x);
            ys.add(y);

            var c = x - y;
            d = Tools.gcd(c, n);

            if (x == y) {
                break;
            }
        }

        xs.clear();
        ys.clear();

        return d;
    }

    private static long func(long n, long p) {
        return (n * n + 1) % p;
    }

    public static void main(String[] args) {
        long i = 123456789;
        long x = 2500744714570633849L;
        long[] longs = new long[]{
                3009182572376191L,
                1021514194991569L,
                4000852962116741L, // 63252296
                15196946347083L,
                499664789704823L,
                269322119833303L,
                679321846483919L,
                96267366284849L,
                61333127792637L,
                2485021628404193L
        };

        System.out.println(rhoPollard(i));
        System.out.println(rhoPollard(x));
        for (long l : longs) {
            System.out.println(rhoPollard(l));
        }
    }
}