package main;

import java.util.Random;

public class SimplicityTest {
    public static boolean isPrime(int p) {
        if (p % 2 == 0) {
            return false;
        }
        Random random = new Random();
        int x = random.nextInt(p);
        if (x == 0) {
            x++;
        }
        if (x == p) {
            x--;
        }
        int one;
        for (int k = 0; k < 125; k++) {
            if (Tools.gcd(p, x) > 1) {
                return false;
            }
            if (Tools.power(x, p) == 1) {
                one = 1;
            } else {
                one = -1;
            }
            if (one != Tools.jacobi(x, p)) {
                return false;
            }
        }
        return true;
    }
}
