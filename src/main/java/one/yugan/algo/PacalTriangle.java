package one.yugan.algo;

import java.util.HashMap;
import java.util.Map;

/**
 * @author : yugan.
 * @date : 2023/8/19
 * @email : eureka_sacha@outlook.com
 */
public class PacalTriangle {

    /**
     * 1
     * 1    1
     * 1    2   1
     * 1    3   3   1
     * 1    4   6   4   1
     *
     *
     *
     * 1    2   1   0
     *
     * @param i
     * @return sum
     */
    public static int printTriangle(int i) {
        if (i <= 0) {
            return -1;
        }
        int sum = 0;
        for (int i1 = 0; i1 < i; i1++) {
            for (int i2 = 0; i2 < i1 + 1; i2++) {
                int ele = element(i1, i2);
                sum += ele;
                System.out.print(ele + "\t");
            }
            System.out.println();
        }
        return sum;
    }

    public static int printTriangle2(int i) {
        if (i <= 0) {
            return -1;
        }
        int[] row = new int[i+1];
        int sum = 0;
        for (int i1 = 0; i1 < i; i1++) {
            createRow(row, i1);
            for (int i2 : row) {
                sum += i2;
                System.out.printf("%-4d", i2);
            }
            System.out.println();
        }
        return sum;
    }

    private static void createRow(int[] row, int n) {
        if (n == 0) {
            row[0] = 1;
            return;
        }
        for (int i = n; i > 0; i--) {
            row[i] = row[i] + row[i - 1];
        }
    }

    public static Map<String, Integer> CACHE = new HashMap<>();

    private static int element(int i, int j) {
        if (j == 0 || i == j) {
            return 1;
        }
        if (CACHE.containsKey(String.format("%s:%s", i - 1, j))) {
            return CACHE.get(String.format("%s:%s", i - 1, j)) + CACHE.get(String.format("%s:%s", i - 1, j - 1));
        }
        CACHE.put(String.format("%s:%s", i - 1, j), element(i - 1, j));
        CACHE.put(String.format("%s:%s", i - 1, j - 1), element(i - 1, j - 1));
        return CACHE.get(String.format("%s:%s", i - 1, j)) + CACHE.get(String.format("%s:%s", i - 1, j - 1));
    }

    public static void main(String[] args) {
        long times = System.currentTimeMillis();
        int num = 10;
        int sum = printTriangle(num);
        System.out.printf("sum=%s%n", sum);
        System.out.printf("cost=%sms%n", System.currentTimeMillis() - times);
        System.out.printf("cache.size=%s%n", CACHE.size());

        times = System.currentTimeMillis();
        sum = printTriangle2(num);
        System.out.printf("sum=%s%n", sum);
        System.out.printf("cost=%sms%n", System.currentTimeMillis() - times);

    }
}
