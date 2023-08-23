package one.yugan.algo;

/**
 * @author : yugan.
 * @date : 2023/8/23
 * @email : eureka_sacha@outlook.com
 */
public class ProductExceptSelf {

    /**
     * 238. 除自身以外数组的乘积
     *
     * 输入: nums = [1,2,3,4]
     * 输出: [24,12,8,6]
     * 列出两个新数组, L和R
     * L[0]=1
     * R[length-1]=1
     * L[1]=L[0](也就是1)*nums[0]
     * L[2]=L[1]*nums[1]
     * ...
     * R[length-2]=R[length-1]*nums[length-1]
     * R[length-3]=R[length-2]*nums[length-2]
     * ...
     * 最后, L * R 得出result
     *
     * @param nums
     * @return
     */
    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int length = nums.length;
        // L 和 R 分别表示左右两侧的乘积列表
        int[] L = new int[length];
        int[] R = new int[length];

        int[] answer = new int[length];

        // L[i] 为索引 i 左侧所有元素的乘积
        // 对于索引为 '0' 的元素，因为左侧没有元素，所以 L[0] = 1
        L[0] = 1;
        for (int i = 1; i < length; i++) {
            L[i] = nums[i - 1] * L[i - 1];
        }

        // R[i] 为索引 i 右侧所有元素的乘积
        // 对于索引为 'length-1' 的元素，因为右侧没有元素，所以 R[length-1] = 1
        R[length - 1] = 1;
        for (int i = length - 2; i >= 0; i--) {
            R[i] = nums[i + 1] * R[i + 1];
        }

        // 对于索引 i，除 nums[i] 之外其余各元素的乘积就是左侧所有元素的乘积乘以右侧所有元素的乘积
        for (int i = 0; i < length; i++) {
            answer[i] = L[i] * R[i];
        }

        return answer;
    }
}
