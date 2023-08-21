package one.yugan.algo;

/**
 * @author : yugan.
 * @date : 2023/8/21
 * @email : eureka_sacha@outlook.com
 */
public class RotatedArraySearch {


    //如果是一个允许重复的旋转数组,就只能O(N)查找了
    public static int search(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        for (int i = 0; i < nums.length; i++) {
            if (k == nums[i]) {
                return i;
            }
        }
        return -1;
    }
}
