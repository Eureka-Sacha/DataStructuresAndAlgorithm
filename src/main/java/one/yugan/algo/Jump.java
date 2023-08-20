package one.yugan.algo;

/**
 * @author : yugan.
 * @date : 2023/8/20
 * @email : eureka_sacha@outlook.com
 */
public class Jump {
    public static int jump(int[] nums) {
        int border = 0;
        int maxPosition = 0;
        int steps = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxPosition = Math.max(maxPosition, nums[i] + i);
            if (i == border) {
                border = maxPosition;
                steps++;
            }
        }
        return steps;
    }
}
