package main;

import java.util.function.BiFunction;
import java.util.function.Function;

public class TonelliShanksAlgorithmLong {
    private record Solution(long root1, long root2, boolean exists) { }

    private static Solution ts(long n, long p) {

        BiFunction<Long, Long, Long> pow = (Long a, Long e) -> {
            long result = 1L;
            for (long i = 0; i < e; i++) {
                result = (result * a) % p;
            }
            return result;
        };

        Function<Long, Long> eulerMod = (Long a) -> pow.apply(a, (p - 1) / 2);

        if (!eulerMod.apply(n).equals(1L)) {
            return new Solution(0, 0, false);
        }

        long q = p - 1;
        long s = 0;
        while ((q & 1) == 0) {
            s++;
            q >>= 1;
        }

        if (s == 1L) {
            long r1 = pow.apply(n, (p + 1) / 4);
            return new Solution(r1, p - r1, true);
        }

        long z = 2L;
        while (!eulerMod.apply(z).equals(p - 1)) {
            z++;
        }

        long c = pow.apply(z, q);
        long r = pow.apply(n, (q + 1) / 2);
        long t = pow.apply(n, q);
        long m = s;
        while (true) {
            if (t == 1) {
                return new Solution(r, p - r, true);
            }

            long i = 0;
            long zz = t;
            while (zz != 1 && i < m - 1) {
                zz = (zz * zz) % p;
                i++;
            }

            long b = c;
            long e = m - i - 1;
            while (e > 0) {
                b = (b * b) % p;
                e--;
            }

            r = (r * b) % p;
            c = (b * b) % p;
            t = (t * c) % p;
            m = i;
        }
    }

    public long[] getSolution(long n, long p){
        TonelliShanksAlgorithmLong.Solution solution = TonelliShanksAlgorithmLong.ts(n, p);

        if (!solution.exists) {
            throw new IllegalArgumentException("There no solution in r^2 = " + n + " (mod " + p + ")");
        }

        return new long[]{ solution.root1, solution.root2};
    }
}
