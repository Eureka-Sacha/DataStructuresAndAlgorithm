package one.yugan;

/**
 * @author : yugan.
 * @date : 2023/8/19
 * @email : eureka_sacha@outlook.com
 */
public class BubbleEnhance {
    public static void sort(int[] source){
        bubbleEnhance(source,source.length-1);
    }


    private static void bubbleEnhance(int [] source,int p){
        if (p <= 0) {
            return;
        }
        int x = 0;
        for (int i = 0; i < p; i++) {
            if (source[i] > source[i + 1]) {
                x = i;
                int t = source[i];
                source[i] = source[i + 1];
                source[i + 1] = t;
            }
        }
        bubbleEnhance(source, x);
    }

    public static void main(String[] args) {
        DataStructuresCollect.testAllIntArrayCollect(BubbleEnhance::sort);
    }
}
