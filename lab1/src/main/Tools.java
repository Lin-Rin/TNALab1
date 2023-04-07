package main;

public class Tools {

    public static long gcd(long a, long b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static long modPow(long a, long exp){
        throw new UnsupportedOperationException();
    }


    // TODO
    public static long gcd1(long a, long b){
        if(a == 0 && b == 0)
            return 0;
        if(a == 0)
            return b;
        if(b == 0)
            return a;

        long d = 1;

        while (even(a) && even(b)){
            a /= 2;
            b /= 2;
            d *= 2;
        }

        while (even(a)){
            a = a / 2;
        }

        while (b != 0){
            while (even(b)) {
                b = b / 2;
            }

            long tempA = a;
            long tempB = b;

            a = Math.max(tempA, tempB);
            b = tempA < tempB ? tempA - tempB : tempB - tempA;
        }
        return d * a;
    }

    private static boolean even(long a){
        return (a & 1) == 0;
    }
}
