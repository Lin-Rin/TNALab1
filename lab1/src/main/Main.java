package main;

// TODO
// 1. Тест на простоту (Мiллера-Рабiна або Соловея-Штрассена)
// 2. Метод пробних дiлень
// 3. ρ-метод Полларда
// 4. Метод Брiлхарта-Моррiсона або метод Померанця
// 5. канонічний розклад ....
// 6. docker
// 7. Run

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random rand = new Random();
        int num = 0;

        for( int i = 0; i < 10000; i++){
            num = rand.nextInt(10);
            System.out.println(num);
        }
    }

}

