package test;

import main.SimplicityTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class SimplicityTestTest {

    private final SimplicityTest test = new SimplicityTest();

    @Test
    void surePrimeTest1() {
        boolean[] expected = new boolean[]{
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true
        };
        boolean[] actual = new boolean[expected.length];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = test.isPrime(13);
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void surePrimeTest2() {
        boolean[] expected = new boolean[]{
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true
        };
        boolean[] actual = new boolean[expected.length];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = test.isPrime(113);
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void surePrimeTest3() {
        boolean[] expected = new boolean[]{
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true
        };
        boolean[] actual = new boolean[expected.length];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = test.isPrime(99607);
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void surePrimeTest4() {
        boolean[] expected = new boolean[]{
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true
        };
        boolean[] actual = new boolean[expected.length];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = test.isPrime(86531);
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void surePrimeTest5() {
        boolean[] expected = new boolean[]{
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true
        };
        boolean[] actual = new boolean[expected.length];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = test.isPrime(179563);
        }

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void noSurePrimeTest1() {
        boolean[] expected = new boolean[]{
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true
        };
        boolean[] actual = new boolean[expected.length];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = test.isPrime(15);
        }

        Assertions.assertFalse(Arrays.equals(expected, actual));
    }

    @Test
    void noSurePrimeTest2() {
        boolean[] expected = new boolean[]{
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true
        };
        boolean[] actual = new boolean[expected.length];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = test.isPrime(112);
        }

        Assertions.assertFalse(Arrays.equals(expected, actual));
    }

    @Test
    void noSurePrimeTest3() {
        boolean[] expected = new boolean[]{
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true
        };
        boolean[] actual = new boolean[expected.length];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = test.isPrime(39121);
        }

        Assertions.assertFalse(Arrays.equals(expected, actual));
    }

    @Test
    void noSurePrimeTest4() {
        boolean[] expected = new boolean[]{
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true
        };
        boolean[] actual = new boolean[expected.length];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = test.isPrime(196183);
        }

        Assertions.assertFalse(Arrays.equals(expected, actual));
    }

    @Test
    void noSurePrimeTest5() {
        boolean[] expected = new boolean[]{
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true,
                true, true, true, true, true, true, true, true, true, true
        };
        boolean[] actual = new boolean[expected.length];

        for (int i = 0; i < expected.length; i++) {
            actual[i] = test.isPrime(122923);
        }

        Assertions.assertFalse(Arrays.equals(expected, actual));
    }
}
