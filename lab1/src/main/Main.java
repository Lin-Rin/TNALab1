package main;

// TODO
// 1. issue Тест на простоту (Мiллера-Рабiна або Соловея-Штрассена)
// 2. DONE Метод пробних дiлень
// 3. DONE ρ-метод Полларда DONE
// 4. Метод Померанця
// 5. Канонічний розклад ....
// 6. docker
// 7. Run

import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.print("Enter number: ");
        var input = in.nextLong();
        try {
            System.out.println("Result is: " + new CanonicalDistribution(input).getDistribution());
        } catch (Exception e) {
            System.out.println(e.getMessage());;
        }

    }
}

