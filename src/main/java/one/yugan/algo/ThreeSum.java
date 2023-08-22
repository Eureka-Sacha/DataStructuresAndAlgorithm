package one.yugan.algo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import one.yugan.DataStructuresCollect;
import one.yugan.sort.Merge;

/**
 * @author : yugan.
 * @date : 2023/8/22
 * @email : eureka_sacha@outlook.com
 */
public class ThreeSum {

    public static void main(String[] args) {
        int[] nums = DataStructuresCollect.INT_ARRAY_COLLECT.get(5);
        int target = 10;
        Merge.sort(nums);
        System.out.println(Arrays.toString(nums)+"\n");
        List<List<Integer>> result = findElement(nums, target);
        for (List<Integer> integers : result) {
            System.out.println(integers.toString());
        }
    }

    public static List<List<Integer>> findElement(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        List<List<Integer>> result = new ArrayList<>();
        //为啥是-2呢, 因为这里要找三个数; i=n-1 的话就没必要循环了, 所以i的最大值是n-3
        for (int i = 0; i < nums.length-2; i++) {
            //如果有重复的数字,跳过.
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //创建两个指针, 用来循环和nums[i]一起计算是否等与target
            int start = i + 1;
            int end = nums.length - 1;
            while (start < end) {
                if (nums[i] + nums[start] + nums[end] == target) {
                    List<Integer> list = new ArrayList<>();
                    //如果需要输出坐标,就改为i,start,end
                    list.add(nums[i]);
                    list.add(nums[start]);
                    list.add(nums[end]);
                    result.add(list);
                    //分别步进两个指针
                    start++;
                    end--;
                    //因为可能存在重复数值,所以需要跳过
                    while (start < end && nums[start] == nums[start - 1]) {
                        start++;
                    }
                    while (start < end && nums[end] == nums[end + 1]) {
                        end--;
                    }
                }
                //如果和比目标小就移动左指针, 为啥? 因为数组是有序的,左小右大,左边总是更小的
                if (nums[i] + nums[start] + nums[end] < target) {
                    start++;
                }
                //如果和比目标大就移动右指针,因为数组右边总是更大的
                if (nums[i] + nums[start] + nums[end] > target) {
                    end--;
                }
            }
        }
        return result;
    }
}
