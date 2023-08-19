package one.yugan;

/**
 * @author : yugan.
 * @date : 2023/8/19
 * @email : eureka_sacha@outlook.com
 */
public class Bubble {

    public static void sort(int[] source) {
        bubbleSort(source, source.length - 1);
    }

    private static void bubbleSort(int[] source, int p) {
        if (p <= 0) {
            return;
        }
        for (int i = 0; i < p; i++) {
            if (source[i] > source[i + 1]) {
                int t = source[i];
                source[i] = source[i + 1];
                source[i + 1] = t;
            }
        }
        bubbleSort(source, p - 1);
    }

    public static void main(String[] args) {
        DataStructuresCollect.testAllIntArrayCollect(Bubble::sort);
    }
}
