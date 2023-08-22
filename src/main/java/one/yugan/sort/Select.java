package one.yugan.sort;

import one.yugan.DataStructuresCollect;

/**
 * @author : yugan.
 * @date : 2023/8/22
 * @email : eureka_sacha@outlook.com
 */
public class Select {
    public static void main(String[] args) {
        DataStructuresCollect.testAllIntArrayCollect(Select::sort);

    }
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        select(nums);

    }

    private static void select(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int pos = i;
            for (int i1 = i + 1; i1 < nums.length; i1++) {
                if (nums[pos] > nums[i1]) {
                    pos = i1;
                }
            }
            if (pos != i) {
                int t = nums[pos];
                nums[pos] = nums[i];
                nums[i] = t;
            }
        }
    }
}
