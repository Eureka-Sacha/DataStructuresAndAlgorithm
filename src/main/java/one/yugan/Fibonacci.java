package one.yugan;

import java.util.Arrays;

/**
 * @author : yugan.
 * @date : 2023/8/19
 * @email : eureka_sacha@outlook.com
 */
public class Fibonacci {

    public static int fibonacci(int num) {
        int[] cache = new int[num + 1];
        Arrays.fill(cache, -1);
        cache[0] = 0;
        cache[1] = 1;
        return fibonacci(num, cache);
    }

    public static int fibonacci(int num,int[]cache){
        if (cache[num] != -1) {
            return cache[num];
        }
        int x = fibonacci(num - 1, cache);
        int y = fibonacci(num - 2, cache);
        cache[num] = x + y;
        return cache[num];
    }

    public static void main(String[] args) {
        System.out.println(fibonacci(10));
    }
}
