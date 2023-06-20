package main;

import java.util.Scanner;
import java.util.concurrent.*;

public class Main {

    private static void runBruteForce(long a, long b, long n) {
        long timeout = 5 * 60 * 1000;

        Thread algorithmThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            System.out.println("Result is: " + AlgorithmSilverPohligHellman.bruteForceSearch(a, b, n));
            long end = System.currentTimeMillis();
            System.out.println("Elapsed time: " + (end - start) + "ms");
        });

        algorithmThread.start();

        try {
            algorithmThread.join(timeout);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        if (algorithmThread.isAlive()) {
            algorithmThread.interrupt();
            System.out.println("Time out");
        }
    }

    private static void runAlgorithmSilverPohligHellman(long a, long b, long n) {
        long timeout = 5 * 60 * 1000;

        Thread algorithmThread = new Thread(() -> {
            long start = System.currentTimeMillis();
            System.out.println("Result is: " + AlgorithmSilverPohligHellman.algorithmSilverPohligHellman(a, b, n));
            long end = System.currentTimeMillis();
            System.out.println("Elapsed time: " + (end - start) + "ms");
        });

        algorithmThread.start();

        try {
            algorithmThread.join(timeout);
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        if (algorithmThread.isAlive()) {
            algorithmThread.interrupt();
            System.out.println("Time out");
        }

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long a, b, n;
        boolean isChosenBruteForce;

        System.out.println("Welcome to NTA 2!");
        System.out.print("Choose run bruteForce or algorithm (0/1):");
        isChosenBruteForce = in.nextLong() == 0;

        System.out.print("Input generator (a): ");
        a = in.nextLong();
        System.out.print("Input element   (b): ");
        b = in.nextLong();
        System.out.print("Input module    (n): ");
        n = in.nextLong();

        if (isChosenBruteForce) {
            ExecutorService executor = Executors.newSingleThreadExecutor();

            Future<?> future = executor.submit(() -> runBruteForce(a, b, n));

            try {
                future.get(5, TimeUnit.MINUTES);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                future.cancel(true);
                System.out.println("Timeout");
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            executor.shutdown();
        } else {
            ExecutorService executor = Executors.newSingleThreadExecutor();

            Future<?> future = executor.submit(() -> runAlgorithmSilverPohligHellman(a, b, n));

            try {
                future.get(5, TimeUnit.MINUTES);
            } catch (InterruptedException | ExecutionException | TimeoutException e) {
                future.cancel(true);
                System.out.println("Timeout");
            } catch (Exception e) {
                System.out.println(e.toString());
            }

            executor.shutdown();
        }
    }
}