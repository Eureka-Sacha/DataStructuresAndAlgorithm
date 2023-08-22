package one.yugan.sort;

import one.yugan.DataStructuresCollect;

/**
 * @author : yugan.
 * @date : 2023/8/22
 * @email : eureka_sacha@outlook.com
 */
public class Quick {

    public static void main(String[] args) {
        DataStructuresCollect.testAllIntArrayCollect(Quick::sort);
    }

    public static void sort(int[] nums) {
        quick(nums, 0, nums.length-1);
    }

    /**
     *
     * 快排是不稳定的, 但是不使用额外空间
     * PS:不稳定是指,如果数组中存在相同的数字,排序时可能会交换他们的位置.
     * 快排一共三部分
     * 1. 找一个基准值(随便一个)
     * 2. 循环遍历,把大于基准值的放到基准值右边(left++),把小于基准值的放到基准值左边(right--)
     * 3. 循环完成后, right 指针会大于 left 指针, 这个时候,使用head和right迭代左半部分,使用left和tail迭代后半部分
     *
     * @param nums
     * @param head
     * @param tail
     */
    public static void quick(int[] nums,int head,int tail) {
        if (head >= tail) {
            return;
        }
        //找到基准值
        int base = nums[(head + tail) >> 1];
        //额外定义一个left和right指针
        int left = head;
        int right = tail;
        //循环遍历, 以基准值为中心, 左右排列,比基准值大的放基准值左边,比基准值小的放基准值右边
        while (left <= right) {
            //二次循环找到小于基准值的下标
            while (left <= right && nums[left] < base) {
                left++;
            }
            //二次循环,找到大于基准值的下标
            while (left <= right && nums[right] > base) {
                right--;
            }
            //交换大于基准值的和小于基准值的
            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
            //到此,已经以基准值为中心分为了左边和右边,推出循环后,right会大于left
        }
        //迭代排列左半部分
        quick(nums, head, right);
        //迭代排列右半部分
        quick(nums, left, tail);
    }
}
