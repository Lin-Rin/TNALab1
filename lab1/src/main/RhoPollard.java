package main;

public class RhoPollard {

    private final Tools tool = new Tools();

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
        long[] x = new long[]{
                3009182572376191L,
                1021514194991569L,
                4000852962116741L,
                15196946347083L,
                499664789704823L,
                269322119833303L,
                679321846483919L,
                96267366284849L,
                61333127792637L,
                2485021628404193L
        };

        try {
            for (long l : x) {
                long start = System.nanoTime();
                long res = rhoPollard.rhoPollard(l);
                long end = System.nanoTime();

                System.out.println("Result for " + l + " is " + res + ", time (ns) " + ((end - start)));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

}