package main;

public class Tools {

    public static long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        if (a == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

    public static int jacobi(long a, long n) {
        if (a < 0 || n % 2 == 0)
            throw new IllegalArgumentException("Wrong argument: (a, n) -- (" + a + ", " + n + ")");
        if (a == 0)
            return 0;
        if (a == 1)
            return 1;

        int e = 0;
        int s = 0;

        while (a % 2 != 1) {
            e++;
            a = a / 2;
        }

        if (e % 2 == 0)
            s = 1;
        else {
            if (n % 8 == 1 || n % 8 == 7)
                s = 1;
            if (n % 8 == 3 || n % 8 == 5)
                s = -1;
        }

        if (n % 4 == 3 && a % 4 == 3)
            s *= -1;
        n = n % a;

        return a == 1 ? s : s * jacobi(n, a);
    }

    public static long power(int a, int b, int n) {
        int res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * a) % n;
            }
            a = (a * a) % n;
            b >>= 1;
        }
        return res;
    }

}