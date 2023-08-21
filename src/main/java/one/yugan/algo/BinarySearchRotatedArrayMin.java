package one.yugan.algo;

/**
 * @author : yugan.
 * @date : 2023/8/21
 * @email : eureka_sacha@outlook.com
 */
public class BinarySearchRotatedArrayMin {

    /**
     * 找到旋转数组中的最小值
     *
     * 输入：nums = [3,4,5,1,2]
     * 输出：1
     * 解释：原数组为 [1,2,3,4,5] ，旋转 3 次得到输入数组。
     *
     * @param nums
     * @return
     */
    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0;
        int end = nums.length - 1;
        int target = nums[0];
        while (start + 1 < end) {
            int mid = (start + end) >> 1;
            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        return Math.min(nums[start], nums[end]);
    }

    public static void main(String[] args) {
        int[] nums = new int[] {3, 4, 5, 1, 2};
        System.out.println(findMin(nums));

    }
}
