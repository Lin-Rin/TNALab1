package main;

import java.util.Random;

public class SimplicityTest {
    private final Tools tool = new Tools();

    public boolean isPrime(long p) {
        if (p < 2)
            return false;
        double s = Math.sqrt(p);
        for (int i = 2; i <= s; i++) {
            if (p % i == 0)
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        int i ;
        for ( i = 0; i < 10; i++) {
            System.out.println(new SimplicityTest().isPrime(i));
        }
    }
}
