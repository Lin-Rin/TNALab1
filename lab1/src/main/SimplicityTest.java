package main;

import java.util.Random;

public class SimplicityTest {
    private final Tools tool = new Tools();

    public boolean isPrime(long p) {
        if (p % 2 == 0) {
            return false;
        }

        for (int k = 0; k < 1000; k++) {
            Random random = new Random();
            long x = random.nextLong(p);

            if (x == 0) {
                x++;
            }
            if (x == p) {
                x--;
            }

            if (tool.gcd(p, x) > 1) {
                return false;
            }

            long jacobiRes = tool.jacobi(x, p);
            if (jacobiRes < 0) {
                jacobiRes = p - 1;
            }

            // gcd = jacobi = modPower = 1 = proste
            if (jacobiRes != tool.modPow(x, (p - 1) / 2, p)) {
                return false;
            }
        }
        return true;
    }

}
