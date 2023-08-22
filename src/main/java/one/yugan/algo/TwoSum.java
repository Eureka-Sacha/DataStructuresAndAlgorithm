package one.yugan.algo;

import java.util.Arrays;

import one.yugan.DataStructuresCollect;
import one.yugan.sort.Merge;

/**
 * @author : yugan.
 * @date : 2023/8/22
 * @email : eureka_sacha@outlook.com
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = DataStructuresCollect.INT_ARRAY_COLLECT.get(5);
        int target = 3;
        Merge.sort(nums);
        System.out.println(Arrays.toString(nums) + "\n");
        int[] result = findIndexes(nums, target);
        System.out.println(Arrays.toString(result));
    }

    public static int[] findIndexes(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int[] result = new int[2];
        int start = 0;
        int end = nums.length - 1;
        while (start < end) {
            if (nums[start] + nums[end] == target) {
                result[0] = start;
                result[1] = end;
                break;
            }
            if (nums[start] + nums[end] < target) {
                start++;
            }
            if (nums[start] + nums[end] > target) {
                end--;
            }
        }
        return result;
    }
}
