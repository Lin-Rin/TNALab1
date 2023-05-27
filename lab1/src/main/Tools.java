package main;

import java.io.*;
import java.util.ArrayList;

public class Tools {

    private final static String FILE_PATH1  = "lab1/src/res/primes100k.txt";
    private final static String FILE_PATH2  = "lab1/src/res/primes200k.txt";
    private final static String FILE_PATH3  = "lab1/src/res/primes300k.txt";
    private final static String FILE_PATH4  = "lab1/src/res/primes400k.txt";
    private final static String FILE_PATH5  = "lab1/src/res/primes500k.txt";
    private final static String FILE_PATH6  = "lab1/src/res/primes600k.txt";
    private final static String FILE_PATH7  = "lab1/src/res/primes700k.txt";
    private final static String FILE_PATH8  = "lab1/src/res/primes800k.txt";
    private final static String FILE_PATH9  = "lab1/src/res/primes900k.txt";
    private final static String FILE_PATH10 = "lab1/src/res/primes1000k.txt";

    public long[] getPrimeNumbers() throws IOException {
        InputStream srcFile1  = new FileInputStream(Tools.FILE_PATH1);
        InputStream srcFile2  = new FileInputStream(Tools.FILE_PATH2);
        InputStream srcFile3  = new FileInputStream(Tools.FILE_PATH3);
        InputStream srcFile4  = new FileInputStream(Tools.FILE_PATH4);
        InputStream srcFile5  = new FileInputStream(Tools.FILE_PATH5);
        InputStream srcFile6  = new FileInputStream(Tools.FILE_PATH6);
        InputStream srcFile7  = new FileInputStream(Tools.FILE_PATH7);
        InputStream srcFile8  = new FileInputStream(Tools.FILE_PATH8);
        InputStream srcFile9  = new FileInputStream(Tools.FILE_PATH9);
        InputStream srcFile10 = new FileInputStream(Tools.FILE_PATH10);
        ArrayList<Long> res = new ArrayList<>();

        for(String s : readFromInputStream(srcFile1).split("\n")){
                res.add(Long.parseLong(s));
        }
        for(String s : readFromInputStream(srcFile2).split("\n")){
            res.add(Long.parseLong(s));
        }
        for(String s : readFromInputStream(srcFile3).split("\n")){
            res.add(Long.parseLong(s));
        }
        for(String s : readFromInputStream(srcFile4).split("\n")){
            res.add(Long.parseLong(s));
        }
        for(String s : readFromInputStream(srcFile5).split("\n")){
            res.add(Long.parseLong(s));
        }
        for(String s : readFromInputStream(srcFile6).split("\n")){
            res.add(Long.parseLong(s));
        }
        for(String s : readFromInputStream(srcFile7).split("\n")){
            res.add(Long.parseLong(s));
        }
        for(String s : readFromInputStream(srcFile8).split("\n")){
            res.add(Long.parseLong(s));
        }
        for(String s : readFromInputStream(srcFile9).split("\n")){
            res.add(Long.parseLong(s));
        }
        for(String s : readFromInputStream(srcFile10).split("\n")){
            res.add(Long.parseLong(s));
        }

        System.out.println(res.size());

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