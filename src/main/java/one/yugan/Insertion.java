package one.yugan;

/**
 * @author : yugan.
 * @date : 2023/8/19
 * @email : eureka_sacha@outlook.com
 */
public class Insertion {

    public static void sort(int[] source) {
        insertion(source, 0);
    }

    private static void insertion(int[] source, int p) {
        if (p >= source.length) {
            return;
        }
        int t = source[p];
        int i = p - 1;
        while (i >= 0 && source[i] > t) {
            source[i + 1] = source[i];
            i--;
        }
        if (i + 1 != p) {
            source[i + 1] = t;
        }
        insertion(source, p + 1);
    }

    public static void main(String[] args) {
        DataStructuresCollect.testAllIntArrayCollect(Insertion::sort);
    }
}
