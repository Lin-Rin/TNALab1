package main;

public class WheelFactorization {

    private final long[] nums = new long[]
            {2, 3, 5, 7, 11, 17, 19, 23, 29, 31, 37, 41, 43, 47};

    // TODO there the way to optimize code
    public long trial(long n, long[] primes) {
        for (long i : primes) {
            if (n % i == 0) {
                return i;
            }
        }

        return n;
    }
}