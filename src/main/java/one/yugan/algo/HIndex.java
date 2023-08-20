package one.yugan.algo;

import java.util.Arrays;

/**
 * @author : yugan.
 * @date : 2023/8/20
 * @email : eureka_sacha@outlook.com
 */
public class HIndex {
    public static int hIndex(int[] nums) {
        Arrays.sort(nums);
        int h = 0, i = nums.length - 1;
        while (i >= 0 && nums[i] > h) {
            h++;
            i--;
        }
        return h;
    }

    public static void main(String[] args) {
        int[] nums = {3, 0, 6, 1, 5};
        System.out.println(hIndex(nums));

    }
}
