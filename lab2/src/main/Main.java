package main;

import org.apache.commons.math3.primes.Primes;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

//TODO

public class Main {
    public ArrayList<Integer> factorization(int n){
        return new ArrayList<>(Primes.primeFactors(n));
    }

    public static void main(String[] args) {

    }
}