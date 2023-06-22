package main;

import java.io.*;
import java.util.*;
import java.util.stream.IntStream;

public class IndexCalculus {

    private static final long C = 20;

    private static Map<Boolean, ArrayList<Long>> isSmooth(long value, ArrayList<Long> S) {
        long[] res = new long[S.size()];

        for (int i = 0; i < S.size(); i++) {
            while (value % S.get(i) == 0) {
                res[i] += 1;
                value = value / S.get(i);
            }
        }

        HashMap<Boolean, ArrayList<Long>> temp = new HashMap<>();
        ArrayList<Long> list = new ArrayList<>();
        Arrays.stream(res).forEach(list::add);

        if (value != 1) {
            temp.put(false, list);
        } else {
            temp.put(true, list);
        }

        return temp;
    }

    private static ArrayList<Long> solve() {
        throw new UnsupportedOperationException();
    }

    public static long algorithmIndexCalculus(long a, long b, long n) {
        double c = 3.38;
        long B =  (long) (c * Math.exp(0.5 * Math.sqrt(log2(n) * log2(log2(n)))));



        return 0;
    }

    public static void main(String[] args) {
        algorithmIndexCalculus(5,11,97);
    }

    private static List<Long> factorBase(long B) {
        try {
            var temp = getPrimeNumbers();
            OptionalInt index = IntStream.range(0, temp.size())
                    .filter(i -> temp.get(i) > B)
                    .findFirst();

            return temp.subList(0, index.getAsInt());
        } catch (IOException e) {
            throw new RuntimeException("Files with prime number NOT FOUND");
        }
    }


    // --------------------------- tools ---------------------------
    private static long pow(long base, long exp, long mod) {
        var res = 1L;

        while (exp > 0) {
            if (exp % 2 == 1) {
                res = (res * base) % mod;
            }

            base = (base * base) % mod;
            exp /= 2;
        }

        return res;
    }

    private long gcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        if (a == 0) {
            return b;
        }

        return gcd(b, a % b);
    }

    private boolean isPrime(long p) {
        if (p % 2 == 0) {
            return false;
        }

        for (int k = 0; k < 1000; k++) {
            Random random = new Random();
            long x = random.nextLong(p);

            if (x == 0) {
                x++;
            }
            if (x == p) {
                x--;
            }

            if (gcd(p, x) > 1) {
                return false;
            }

            long jacobiRes = jacobi(x, p);
            if (jacobiRes < 0) {
                jacobiRes = p - 1;
            }

            if (jacobiRes != modPow(x, (p - 1) / 2, p)) {
                return false;
            }
        }
        return true;
    }

    private int jacobi(long a, long n) {
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

    private long modPow(long a, long e, long p) {
        long result = 1;
        a %= p;

        while (e > 0) {
            if (e % 2 == 1)
                result = (result * a) % p;
            a = (a * a) % p;
            e /= 2;
        }

        return result;
    }

    private static double log2(double num) {
        return Math.log(num) / Math.log(2);
    }


    // --------------------------- file tools ---------------------------
    private final static String FILE_PATH1 = "lab3/src/res/primes100k.txt";
    private final static String FILE_PATH2 = "lab3/src/res/primes200k.txt";
    private final static String FILE_PATH3 = "lab3/src/res/primes300k.txt";
    private final static String FILE_PATH4 = "lab3/src/res/primes400k.txt";
    private final static String FILE_PATH5 = "lab3/src/res/primes500k.txt";
    private final static String FILE_PATH6 = "lab3/src/res/primes600k.txt";
    private final static String FILE_PATH7 = "lab3/src/res/primes700k.txt";
    private final static String FILE_PATH8 = "lab3/src/res/primes800k.txt";
    private final static String FILE_PATH9 = "lab3/src/res/primes900k.txt";
    private final static String FILE_PATH10 = "lab3/src/res/primes1000k.txt";

    private static ArrayList<Long> getPrimeNumbers() throws IOException {
        InputStream srcFile1 = new FileInputStream(IndexCalculus.FILE_PATH1);
        InputStream srcFile2 = new FileInputStream(IndexCalculus.FILE_PATH2);
        InputStream srcFile3 = new FileInputStream(IndexCalculus.FILE_PATH3);
        InputStream srcFile4 = new FileInputStream(IndexCalculus.FILE_PATH4);
        InputStream srcFile5 = new FileInputStream(IndexCalculus.FILE_PATH5);
        InputStream srcFile6 = new FileInputStream(IndexCalculus.FILE_PATH6);
        InputStream srcFile7 = new FileInputStream(IndexCalculus.FILE_PATH7);
        InputStream srcFile8 = new FileInputStream(IndexCalculus.FILE_PATH8);
        InputStream srcFile9 = new FileInputStream(IndexCalculus.FILE_PATH9);
        InputStream srcFile10 = new FileInputStream(IndexCalculus.FILE_PATH10);
        ArrayList<Long> res = new ArrayList<>();

        for (String s : readFromInputStream(srcFile1).split("\n")) {
            res.add(Long.parseLong(s));
        }
        for (String s : readFromInputStream(srcFile2).split("\n")) {
            res.add(Long.parseLong(s));
        }
        for (String s : readFromInputStream(srcFile3).split("\n")) {
            res.add(Long.parseLong(s));
        }
        for (String s : readFromInputStream(srcFile4).split("\n")) {
            res.add(Long.parseLong(s));
        }
        for (String s : readFromInputStream(srcFile5).split("\n")) {
            res.add(Long.parseLong(s));
        }
        for (String s : readFromInputStream(srcFile6).split("\n")) {
            res.add(Long.parseLong(s));
        }
        for (String s : readFromInputStream(srcFile7).split("\n")) {
            res.add(Long.parseLong(s));
        }
        for (String s : readFromInputStream(srcFile8).split("\n")) {
            res.add(Long.parseLong(s));
        }
        for (String s : readFromInputStream(srcFile9).split("\n")) {
            res.add(Long.parseLong(s));
        }
        for (String s : readFromInputStream(srcFile10).split("\n")) {
            res.add(Long.parseLong(s));
        }

        return res;
    }

    private static String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }
}