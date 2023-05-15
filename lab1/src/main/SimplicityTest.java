package main;

import java.util.Random;

public class SimplicityTest {

    // TODO bug
    public boolean isPrime(int p, int k) {
        if (p <= 1 || p == 4) {
            return false;
        }
        if (p <= 3){
            return true;
        }

        Random rand = new Random();

        for (int i = 0; i < k; i++) {
            int a = 2 + rand.nextInt(p - 3);
            if (Tools.gcd(p, a) != 1) {
                return false;
            }
            if (Tools.power(a, (p - 1) / 2, p) != Tools.jacobi(a, p)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        for(int i = 0; i < 10; i++){
            if(new SimplicityTest().isPrime(i, 100))
                System.out.println(new SimplicityTest().isPrime(i, 4) + " " + i);
        }
    }
}