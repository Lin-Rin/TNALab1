package main;

import java.util.Random;

public class SimplicityTest {
    private final Tools tool = new Tools();

    public boolean isPrime(long p) {
        if (p % 2 == 0) {
            return false;
        }

        Random random = new Random();
        long x = random.nextLong(p);
        int one;

        if (x == 0) {
            x++;
        }
        if (x == p) {
            x--;
        }

        for (int k = 0; k < 125; k++) {
            if (Tools.gcd(p, x) > 1) {
                return false;
            }
            if (Tools.power(x, p) == 1) {
                one = 1;
            } else {
                one = -1;
            }
            if (one != tool.jacobi(x, p)) {
                return false;
            }
        }

        return true;
    }
}
