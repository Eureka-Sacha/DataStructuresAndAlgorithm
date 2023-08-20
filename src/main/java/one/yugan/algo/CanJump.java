package one.yugan.algo;

/**
 * @author : yugan.
 * @date : 2023/8/20
 * @email : eureka_sacha@outlook.com
 */
public class CanJump {

    public static boolean canjump(int[] nums) {
        int k = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                return false;
            }
            k = Math.max(k,i+ nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2};
        System.out.println(canjump(nums));
    }
}
