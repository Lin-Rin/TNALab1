package main;

import java.util.Random;

public class SimplicityTest {

    private final Random rand = new Random();

    private boolean test(long p, int k) {
        long s = 0;
        long d = p - 1;
        // p-1 = d * 2^s

        while (d % 2 == 0) {
            s++;
            d /= 2;
        }
        System.out.println("d: " + d + ", s: " + s);

        long x = rand.nextLong(p + 1) + 1;
        if (Tools.gcd(p, x) != 1)
            return false;

        System.out.println("continue...");

        return true;
    }

    public boolean isPrime(long a) {
        throw new UnsupportedOperationException();
    }

    public static void main(String[] args) {
        new SimplicityTest().test(17, 0);
        new SimplicityTest().test(17, 0);
    }
}
