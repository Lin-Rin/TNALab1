package main;

import java.util.Random;

public class SimplicityTest {

    // TODO bug
    public boolean isPrime(long p) {
        if (p % 2 == 0)
            return false;

        Random rand = new Random();

        for (int k = 0; k < 100; k++) {
            long x = rand.nextLong(p) + 1;
            if (Tools.gcd(x, p) != 1)
                return false;

            if (Tools.jacobi(x, p) != Tools.power(x, p))
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10000000; i++){
            if(new SimplicityTest().isPrime(i))
                System.out.println(new SimplicityTest().isPrime(i) + " " + i);
        }
    }
}