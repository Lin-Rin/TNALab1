package main;

import java.util.ArrayList;

public class CanonicalDistribution {

    private ArrayList<Long> getListPrimes(){
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

    private long n;
    private final long[] arrPrime = new long[]{2, 3, 5, 7, 11, 17, 19, 23, 29, 31, 37, 41, 43, 47};
    private final ArrayList<Long> listPrime = getListPrimes();

    private final SimplicityTest primeTest = new SimplicityTest();
    private final WheelFactorization wheel = new WheelFactorization();
    private final RhoPollard rhoPollard = new RhoPollard();

    public CanonicalDistribution(long n){
        this.n = n;
    }

    public ArrayList<Long> getDistribution() {
        ArrayList<Long> result = new ArrayList<>();

        //if (!test.isPrime(n)) {
        //    result.add(n);
        //    return result;
        //}

        for (long i : arrPrime) {
            long a = wheel.trial(n, listPrime);
            n = n / a;
            if (a != 1) {
                result.add(a);
            }
        }

        n = result.get(result.size() - 1);
        result.remove(result.size() - 1);

        var temp1 = rhoPollard.rhoPollard(n);
        var temp2 = n / temp1;
        result.add(temp1);
        result.add(temp2);

        return result;
    }

    public static void main(String[] args) {
        CanonicalDistribution canon = new CanonicalDistribution(2500744714570633849L);

        System.out.println(canon.getDistribution());
        System.out.println(43*58156853827224043L);
        System.out.println(43*7699*7553819174857L);
        System.out.println(2500744714570633849L);
    }
}