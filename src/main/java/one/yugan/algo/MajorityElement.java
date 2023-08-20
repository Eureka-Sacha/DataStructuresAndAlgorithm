package one.yugan.algo;

import java.util.Arrays;

/**
 * @author : yugan.
 * @date : 2023/8/20
 * @email : eureka_sacha@outlook.com
 */
public class MajorityElement {
    public static int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >> 1];
    }
}
