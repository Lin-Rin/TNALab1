package main;

import java.util.ArrayList;

public class CanonicalDistribution {


    private long n;
    private final long[] arrPrime = new long[]{2, 3, 5, 7, 11, 17, 19, 23, 29, 31, 37, 41, 43, 47};
    private final ArrayList<Long> listPrime = getListPrimes();

    private final SimplicityTest primeTest = new SimplicityTest();
    private final WheelFactorization wheel = new WheelFactorization();
    private final RhoPollard rhoPollard = new RhoPollard();
    private final Pomerance pomerance = new Pomerance();

    public CanonicalDistribution(long n) {
        this.n = n;
    }

    public ArrayList<Long> getDistribution() {
        ArrayList<Long> result = new ArrayList<>();

        if (primeTest.isPrime(n)) {
            result.add(n);
            return result;
        }

        for (long i : arrPrime) {
            long a = wheel.trial(n, listPrime);
            n = n / a;
            if (a != 1) {
                result.add(a);
            }
        }

        n = result.get(result.size() - 1);
        result.remove(result.size() - 1);

        long rho;
        while (!primeTest.isPrime(n)) {
            rho = rhoPollard.rhoPollard(n);
            result.add(rho);
            n = n / rho;
        }

        result.add(n);

        // TODO do not work properly
        /*long[] pom;
        try {
                pom = pomerance.pomeranceMethod(n);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        var res1 = pom[0];
        var res2 = pom[1];
        result.add(res1);
        result.add(res2);
        */

        return result;
    }

    private ArrayList<Long> getListPrimes() {
        ArrayList<Long> res = new ArrayList<>();

        res.add(2L);
        res.add(3L);
        res.add(5L);
        res.add(7L);
        res.add(11L);
        res.add(13L);
        res.add(17L);
        res.add(19L);
        res.add(23L);
        res.add(29L);
        res.add(31L);
        res.add(37L);
        res.add(41L);
        res.add(43L);
        res.add(47L);

        return res;
    }
}