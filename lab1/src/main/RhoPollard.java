package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class RhoPollard {

    public long rhoPollard(long p) {
        //ArrayList<Long> dataBase1 = new ArrayList<>();
        //ArrayList<Long> dataBase2 = new ArrayList<>();

        long d;
        long x = 2;
        long y = 2;

        var prevX = x;
        var prevY = y;

        //int k = 0;
        //boolean where = true;
        do {
            //k++;
            x = f(prevX, p);
            y = f(f(prevY, p), p);

            prevX = x;
            prevY = y;

            // if (where){
            //     dataBase1.add(x);
            //     where = false;
            // } else {
            //     dataBase2.add(x);
            //     where = true;
            // }

            d = Tools.gcd(Math.abs(x - y), p);

            if (x == y) {
                x = new Random().nextLong() % p;
                //while (dataBase1.contains(x) || dataBase2.contains(x)) {
                //    x = new Random().nextLong() % p;
                //    System.out.println("#2");
                //}
                y = x;
                d = 1;
            }
        } while (d == 1);

        //System.out.println(k);
        return d;
    }

    private static long f(long n, long p) {
        return (n * n + 1) % p;
    }

    public static void main(String[] args) {
        RhoPollard rhoPollard = new RhoPollard();
        long i = 1021514194991569L;

        try {
            long start = System.nanoTime();
            long res = rhoPollard.rhoPollard(i);
            long end = System.nanoTime();
            System.out.println(res + " time - " + (end - start));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

}