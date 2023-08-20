package one.yugan.algo;

/**
 * @author : yugan.
 * @date : 2023/8/20
 * @email : eureka_sacha@outlook.com
 */
public class RotateArray {
    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        int[] newArr = new int[n];
        for (int i = 0; i < n; ++i) {
            newArr[(i + k) % n] = nums[i];
        }
        System.arraycopy(newArr, 0, nums, 0, n);
    }
}
