package main;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Welcome!");
        System.out.print("Enter number: ");
        var input = in.nextLong();
        try {
            System.out.println("\nResult is: " + new CanonicalDistribution(input).getDistribution());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}