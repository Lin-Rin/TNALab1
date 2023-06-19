package main;

import org.apache.commons.math3.primes.Primes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

//TODO
// ???  factorization
// DONE bruteforce
// algorithm

public class Main {
    public ArrayList<Integer> factorization(int n){
        return new ArrayList<>(Primes.primeFactors(n));
    }

    public static void main(String[] args) {
        int a = 13;
        int b = 13;
        int n = 23;
        System.out.println( bruteForceSearch(a,b,n));
    }

    public static int bruteForceSearch(int a, int b, int n) {
        var temp = 0;

        for (int i = 0; i < n; i++) {
            temp = (int) Math.pow(a, i) % n;
            if (temp == b) {
                return i;
            }
        }

        return 0;
    }
}