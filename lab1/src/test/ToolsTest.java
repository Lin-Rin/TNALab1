package test;

import main.Tools;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ToolsTest {

    @Test
    void GCDTest(){
        Assertions.assertEquals(Tools.GCD(0, 0), 0);
        Assertions.assertEquals(Tools.GCD(0, 13), 13);
        Assertions.assertEquals(Tools.GCD(13, 0), 13);
        Assertions.assertEquals(Tools.GCD(1, 13), 1);
        Assertions.assertEquals(Tools.GCD(13, 1), 1);
        Assertions.assertEquals(Tools.GCD(13, 13), 13);
        Assertions.assertEquals(Tools.GCD(13, 17), 1);
        Assertions.assertEquals(Tools.GCD(13, 65), 13);
        Assertions.assertEquals(Tools.GCD(65, 13), 13);
        Assertions.assertEquals(Tools.GCD(635, 6352), 1);
        Assertions.assertEquals(Tools.GCD(3535, 70), 35);
        Assertions.assertEquals(Tools.GCD(3535, 7), 7);
    }

    @Test
    void JacobiTest(){
        Assertions.assertEquals(Tools.Jacobi(3,  17), -1);
        Assertions.assertEquals(Tools.Jacobi(10, 21), -1);

        Assertions.assertEquals(Tools.Jacobi(7, 35), 0);
        Assertions.assertEquals(Tools.Jacobi(6, 36), -1);

        Assertions.assertEquals(Tools.Jacobi(2, 15), 1);
        Assertions.assertEquals(Tools.Jacobi(19, 35), -1);

        Assertions.assertEquals(Tools.Jacobi(13, 51), -1);
        Assertions.assertEquals(Tools.Jacobi(3, 17), -1);

        Assertions.assertEquals(Tools.Jacobi(31, 77), -1);
        Assertions.assertEquals(Tools.Jacobi(5, 91), -1);
    }
}