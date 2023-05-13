package test;

import main.Tools;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ToolsTest {

    @Test
    void gcdTest(){
        Assertions.assertEquals(Tools.gcd(0, 0), 0);
        Assertions.assertEquals(Tools.gcd(0, 13), 13);
        Assertions.assertEquals(Tools.gcd(13, 0), 13);
        Assertions.assertEquals(Tools.gcd(1, 13), 1);
        Assertions.assertEquals(Tools.gcd(13, 1), 1);
        Assertions.assertEquals(Tools.gcd(13, 13), 13);
        Assertions.assertEquals(Tools.gcd(13, 17), 1);
        Assertions.assertEquals(Tools.gcd(13, 65), 13);
        Assertions.assertEquals(Tools.gcd(65, 13), 13);
        Assertions.assertEquals(Tools.gcd(635, 6352), 1);
        Assertions.assertEquals(Tools.gcd(3535, 70), 35);
        Assertions.assertEquals(Tools.gcd(3535, 7), 7);
    }

    @Test
    void jacobiTest(){
        Assertions.assertEquals(Tools.jacobi(3,  17), -1);
        Assertions.assertEquals(Tools.jacobi(10, 21), -1);
        Assertions.assertEquals(Tools.jacobi(7, 35), 0);

        Assertions.assertEquals(Tools.jacobi(2, 15), 1);
        Assertions.assertEquals(Tools.jacobi(19, 35), -1);
        Assertions.assertEquals(Tools.jacobi(13, 51), 1);

        Assertions.assertEquals(Tools.jacobi(3, 17), -1);
        Assertions.assertEquals(Tools.jacobi(31, 77), -1);
        Assertions.assertEquals(Tools.jacobi(5, 91), 1);
    }

    @Test
    void powerTest() {

    }
}