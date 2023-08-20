package one.yugan;

import java.util.Arrays;

/**
 * @author : yugan.
 * @date : 2023/8/19
 * @email : eureka_sacha@outlook.com
 */
public class Main {
    public static int removeElement(int[] nums, int val) {
        int left = 0;
        int right = 0;
        for (; right < nums.length; right++) {
            if (nums[right] != val) {
                nums[left] = nums[right];
                left++;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        System.out.println(Arrays.toString(nums));
        int n = removeElement(nums, 3);
        System.out.println(n);
        System.out.println(Arrays.toString(nums));
    }
}