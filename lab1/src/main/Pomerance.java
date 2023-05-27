package main;

import java.io.IOException;
import java.util.*;

// TODO
// find zero vector
// calculate x y
// gcd
// final

// question
// lim = ??
// how we need increase A
// in example if we extend factorB and make sieve we will have more potential number
// do we need to low lim?

// potential problem
// "solve", to much solution

public class Pomerance {

    private final Tools tool = new Tools();

    private final static double A = 1 / Math.sqrt(2);
    private final static double LIM = 100;//0.7;

    public long[] pomeranceMethod(long n) throws IOException {
        long m = (long) Math.sqrt(n);
        long M = m - 1; // rand?
        ArrayList<Long> B = buildFactorBase(n);
        long[] BB = B.stream().mapToLong(Long::longValue).toArray();
        long x = 0, y = 0;

        Map<Long, PomeranceObject> lines = new TreeMap<>();
        Map<Long, TreeSet<Long>> solutions = new TreeMap<>();
        Map<Long, PomeranceObject> result = new TreeMap<>();

        System.out.println("n = " + n);
        System.out.println("B = " + B);
        System.out.println("m = " + m);
        System.out.println("M = " + M);

        System.out.println("solution pi=2: " + solve(1649, 2, 5, m));
        System.out.println("solution pi=5: " + solve(1649, 5, 5, m));
        System.out.println("solution pi=7: " + solve(1649, 7, 5, m));

        for (int i = 1; i < BB.length; i++) {
            var temp = solve(n, BB[i], M, m);
            solutions.put(BB[i], temp);

            //System.out.println(temp);
        }

        for (long i = -M; i <= M; i++) {
            lines.put(i, new PomeranceObject(i, n, m, M, getPi(solutions, i)));
        }

        System.out.println();
        // show solution for pi
        for (Map.Entry<Long, TreeSet<Long>> entry : solutions.entrySet()){
            //System.out.println(entry.getKey() + " " + entry.getValue());
        }
        System.out.println();
        for (Map.Entry<Long, PomeranceObject> entry : lines.entrySet()) {
            try {
                if (entry.getValue().getDifference() < LIM) {
                    entry.getValue().setFactor(factorization(entry.getValue().getB(), B)
                            .stream().mapToLong(Long::longValue).toArray());
                    result.put(entry.getKey(), entry.getValue());
                }

            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }

        // show table
        for (Map.Entry<Long, PomeranceObject> entry : result.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue()
                    + Arrays.toString(entry.getValue().getVector(BB)));
        }

        // cal x y if there is one zero element
        for (Map.Entry<Long, PomeranceObject> entry : result.entrySet()) {
            if (isItZeroElement(entry.getValue().getVector(BB))) {
                x = entry.getValue().getA();
                y = (long) Math.sqrt(entry.getValue().getB());
            }
        }

        if (x % n != y) {
            return new long[]{tool.gcd(x - y, n), tool.gcd(x + y, n),};
        }

        return new long[]{0, 0};
    }

    public static void main(String[] args) throws IOException {
        // System.out.println(Arrays.toString(new Pomerance().pomeranceMethod(91L)));
        System.out.println(Arrays.toString(new Pomerance().pomeranceMethod(1649L)));

        // show parameters
    }

    private boolean isItZeroElement(long[] vector) {
        return Arrays.stream(vector).allMatch(l -> l == 0);
    }

    private ArrayList<Long> getPi(Map<Long, TreeSet<Long>> map, long x) {
        ArrayList<Long> pi = new ArrayList<>();
        for (Map.Entry<Long, TreeSet<Long>> entry : map.entrySet()) {
            if (entry.getValue().contains(x)) {
                pi.add(entry.getKey());
            }
        }

        return pi;
    }

    private ArrayList<Long> factorization(long b, ArrayList<Long> B) throws Exception {
        var res = new ArrayList<Long>();
        var wheel = new WheelFactorization();
        var base = B.stream().mapToLong(Long::longValue).toArray();

        if (b < 0) {
            b = Math.abs(b);
            res.add(-1L);
        }

        while (b > 1) {
            var d = wheel.trial(b, base);
            res.add(d);
            b = b / d;
        }

        var temp = res.get(res.size() - 1);
        if (!B.contains(temp)) {
            throw new Exception(temp + " do not factorize in factor base B");
        }

        return res;
    }

    private TreeSet<Long> solve(long n, long pi, long M, long m) {
        TonelliShanksAlgorithmLong solution = new TonelliShanksAlgorithmLong();
        long[] roots = solution.getSolution(n, pi);
        var res = new TreeSet<Long>();

        long root1 = (roots[0] - m) % pi;
        long root2 = (roots[1] - m) % pi;
        for (long i = -(M / pi); i <= (M / pi); i++) {
            res.add(root1 + i * pi);
            res.add(root2 + i * pi);
        }

        return res;
    }

    private static double log2(double num) {
        return Math.log(num) / Math.log(2);
    }

    private ArrayList<Long> buildFactorBase(long n) throws IOException {
        var primeList = tool.getPrimeNumbers();
        var res = new ArrayList<Long>();
        res.add(-1L);
        long L = (long) Math.pow(Math.exp(Math.sqrt(log2(n) * log2(log2(n)))), A);

        if (n % 2 == 1) {
            res.add(2L);
        }

        for (int i = 1; i < L; i++) {
            if (tool.jacobi(n, primeList[i]) == 1) {
                res.add(primeList[i]);
            }
        }

        return res;
    }
}