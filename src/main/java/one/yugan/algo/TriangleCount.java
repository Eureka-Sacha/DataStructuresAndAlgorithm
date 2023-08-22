package one.yugan.algo;

import java.util.Arrays;

/**
 * @author : yugan.
 * @date : 2023/8/22
 * @email : eureka_sacha@outlook.com
 */
public class TriangleCount {

    /**
     * 从给定数组中找到所有可能组成三角形的数量
     * ps: A+B>C  即可构成一个三角形
     *
     * 输入:[3,6,4,7]
     * 输出:3
     *
     * 这道题有点像两数相加.
     * @param nums
     * @return
     */
    public static int triangleCount(int[] nums) {
        if (nums == null || nums.length < 3) {
            return 0;
        }
        //需要排序先
        Arrays.sort(nums);
        //遍历数组,从n-1到2, 为啥到2? 因为小于2就没有三条边了
        int total = 0;
        for (int i = nums.length - 1; i >= 2; i--) {
            int start = 0;
            int end = i - 1;
            //循环检查是否有两条边相加>nums[i]
            while (start < end) {
                //A+B>C
                if (nums[start] + nums[end] > nums[i]) {
                    //为什么total+= end-start?
                    //首先,数组是有序的,nums[start]总是小于nums[end]
                    //nums[start]+nums[end]都大于C了
                    //说明end到start之间的数的和也都大于C
                    total += (end - start);
                    end--;
                }else{
                    start++;
                }
            }
        }
        return total;
    }
}
