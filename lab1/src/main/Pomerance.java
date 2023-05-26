package main;

import java.io.IOException;
import java.util.*;

// TODO
// find zero vector
// find x y
// gcd
// final step

public class Pomerance {

    private final Tools tool = new Tools();

    private final static double A = 1 / Math.sqrt(2);
    private final static double LIM = 0.7;

    public long pomeranceMethod(long n) throws IOException {
        long m = (long) Math.sqrt(n);
        long M = m - 1; // rand?
        ArrayList<Long> B = buildFactorBase(n);
        long[] BB = B.stream().mapToLong(Long::longValue).toArray();
        long x, y;

        Map<Long, PomeranceObject> lines = new TreeMap<>();
        Map<Long, TreeSet<Long>> solutions = new TreeMap<>();
        Map<Long, PomeranceObject> result = new TreeMap<>();

        for (int i = 1; i < BB.length; i++) {
            var temp = solve(n, BB[i], M, m);
            solutions.put(BB[i], temp);
        }

        for (long i = -M; i <= M; i++) {
            lines.put(i, new PomeranceObject(i, n, m, M, getPi(solutions, i)));
        }

        try {
            for (Map.Entry<Long, PomeranceObject> entry : lines.entrySet()) {
                if (entry.getValue().getDifference() < LIM) {
                    entry.getValue().setFactor(factorization(entry.getValue().getB(), B)
                            .stream().mapToLong(Long::longValue).toArray());
                    result.put(entry.getKey(), entry.getValue());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }



        return 0;
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

    public static void main(String[] args) throws Exception {
        var temp = new ArrayList<Long>();
        temp.add(-1L);
        temp.add(2L);
        temp.add(3L);
        temp.add(7L);
        temp.add(31L);

        System.out.println(new Pomerance().factorization(93 * 3, temp));
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

        // convert
        // new ArrayList<>(res)
        return res;
    }

    private static long getL(long n, double a) {
        return (long) Math.pow(Math.exp(Math.sqrt(log2(n) * log2(n))), a);
    }

    private static double log2(double num) {
        return Math.log(num) / Math.log(2);
    }

    private ArrayList<Long> buildFactorBase(long n) throws IOException {
        var primeList = tool.getPrimeNumbers();
        var res = new ArrayList<Long>();
        res.add(-1L);
        //long L = getL(n, A);

        for (int i = 0; i < primeList.length; i++) {
            if (tool.jacobi(n, primeList[i]) == 1) {
                res.add(primeList[i]);
            }
        }

        return res;
    }
}