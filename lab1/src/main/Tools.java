package main;

import java.io.*;
import java.util.ArrayList;

public class Tools {

    private final static String FILE_PATH = "lab1/src/res/primes100k.txt";

    public long[] getPrimeNumbers() throws IOException {
        InputStream srcFile = new FileInputStream(Tools.FILE_PATH);
        ArrayList<Long> res = new ArrayList<>();

        for(String s : readFromInputStream(srcFile).split("\n")){
                res.add(Long.parseLong(s));
        }

        return res.stream().mapToLong(Long::longValue).toArray();
    }

    public String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }

    public long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        if (a == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

    public int jacobi(long a, long n) {
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

    public long power(long a, long n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) == 1) {
                res = (res * a) % n;
            }
            a = (a * a) % n;
            n >>= 1;
        }
        return res;
    }
}