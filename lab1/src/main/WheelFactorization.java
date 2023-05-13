package main;

public class WheelFactorization {

    private final static int[] nums = new int[]
            {2, 3, 5, 7, 11, 17, 19, 23, 29, 31, 37, 41, 43, 47};

    // TODO there the way to optimize code
    public static long trial(long n) {
        for (long i : nums) {
            if (n % i == 0) {
                return i;
            }
        }

        return n;
    }

    public static void main(String[] args) {
        long i = 123456787L;
        long x = 2500744714570633849L;
        long[] longs = new long[]{
                3009182572376191L,
                1021514194991569L,
                4000852962116741L, // 63252296
                15196946347083L,
                499664789704823L,
                269322119833303L,
                679321846483919L,
                96267366284849L,
                61333127792637L,
                2485021628404193L
        };

        System.out.println(trial(i));
        System.out.println(trial(x));
        for (long l : longs) {
            System.out.println(trial(l));
        }
    }
}