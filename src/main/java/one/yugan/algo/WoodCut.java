package one.yugan.algo;

import java.util.Arrays;

/**
 * @author : yugan.
 * @date : 2023/8/22
 * @email : eureka_sacha@outlook.com
 */
public class WoodCut {

    public static void main(String[] args) {
        int[] nums = {234, 114, 456};
        int k = 7;
        System.out.println(Arrays.toString(nums));
        System.out.println("sum=" + Arrays.stream(nums).sum());
        System.out.println("quotient="+(Arrays.stream(nums).sum() / k));
        System.out.println(woodCut(nums, k));
    }
    /**
     * 砍树
     * 给定目标数组, 每个数的含义是原木的长度
     * 给一个K值. 要求至少把所有原木切位K块
     * 输出, 原木按照多长切才能正好符合K块,且最少浪费原木
     *
     *
     * @param nums
     * @param k
     * @return
     */
    public static int woodCut(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (k <= 0) {
            return 0;
        }
        //最短能切多少
        int minLen = 1;
        //最长能切多少
        int maxLen = 0;
        //取数组中的最大值
        for (int num : nums) {
            maxLen = Math.max(maxLen, num);
        }
        //遍历min->max的所有长度
        while (minLen + 1 < maxLen) {
            //取中间值
            int mid = (minLen + maxLen) >> 1;
            //如果按照mid切出来的长度>=K ,就缩小范围继续尝试
            if (count(nums, mid) >= k) {
                minLen = mid;
            }else{
                maxLen = mid;
            }
        }
        //遍历完所有可能性后,如果max切出来的最多就返回max
        if (count(nums, maxLen) >= k) {
            return maxLen;
        }
        //如果min切出来的最多,就返回min
        if (count(nums, minLen) >= k) {
            return minLen;
        }
        //都不符合要求说明切不出来
        return 0;
    }

    //所有原木按照n的长度切最多能切多少
    public static int count(int[] nums, int n) {
        int p = 0;
        for (int num : nums) {
            p += num / n;
        }
        return p;
    }
}
