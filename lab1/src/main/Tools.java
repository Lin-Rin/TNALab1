package main;

public class Tools {

    // TODO review
    public static int gcd(long a, long b) {
        int d = 1;

        while (a % 2 == 0 && b % 2 == 0) {
            a /= 2;
            b /= 2;
            d *= 2;
        }

        while (a % 2 == 0) {
            a /= 2;
        }

        while (b != 0) {
            while (b % 2 == 0) {
                b /= 2;
            }
            if (a > b) {
                var temp = a;
                a = b;
                b = temp - a;
            }else{
                b -= a;
            }
        }

        d *= a;
        return d;
    }

    // TODO review
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

    // TODO optimization
    public static long power(long a, long p) {
        long n = (p - 1) / 2;
        long res = 0;

        res = (long) (Math.pow(a, n) % p);

        return res;
    }

    public static void main(String[] args) {
        System.out.println("res + " + jacobi(6, 36));
    }
}