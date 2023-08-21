package one.yugan.algo;

/**
 * @author : yugan.
 * @date : 2023/8/21
 * @email : eureka_sacha@outlook.com
 */
public class BinarySearchRotatedArray {
    public static int search(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        int start = 0;
        int end = nums.length - 1;
        while (start + 1 < end) {
            int mid = (start + end) >> 1;
            if (nums[mid] == k) {
                return mid;
            }
            if (nums[mid] > nums[start]) {
                if (k >= nums[start] && k <= nums[mid]) {
                    end = mid;
                }else{
                    start = mid;
                }
            }
            if (nums[mid] < nums[end]) {
                if (k >= nums[mid] && k <= nums[end]) {
                    start = mid;
                }else{
                    end = mid;
                }
            }
        }
        if (nums[start] == k) {
            return start;
        }
        if (nums[end] == k) {
            return end;
        }
        return -1;
    }
}
