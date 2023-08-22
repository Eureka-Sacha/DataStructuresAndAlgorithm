package one.yugan.sort;

import one.yugan.DataStructuresCollect;

/**
 * @author : yugan.
 * @date : 2023/8/22
 * @email : eureka_sacha@outlook.com
 */
public class Merge {

    public static void main(String[] args) {
        DataStructuresCollect.testAllIntArrayCollect(Merge::sort);

    }

    /**
     * 合并/归并排序一共有两部
     * 1. 划分    迭代划分就是把所有元素都拆分成单元素,使其一定有序(只有一个元素一定使有序的)
     * 2. 合并    划分完成后,迭代合并成多个有序元素集合.
     * @param nums
     */
    public static void sort(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }
        int[] temp = new int[nums.length];
        partitionAndMerge(nums, 0, nums.length - 1, temp);
    }

    public static void partitionAndMerge(int[] nums,int head,int tail,int[]temp) {
        //head>=tail的时候,说明已经切割为单元素了,不用继续切了
        if (head >= tail) {
            return;
        }
        //找到中间坐标,用于分割
        int mid = (head + tail) >> 1;
        //递归分割左半部分,返回的一定是已经有序的
        partitionAndMerge(nums,head,mid,temp);
        //递归分割右半部分,返回的一定是已经有序的
        partitionAndMerge(nums,mid+1,tail,temp);
        //合并两个有序的部分
        merge(nums, head, mid, tail, temp);
    }

    public static void merge(int[] nums, int head, int mid, int tail, int[] temp) {
        //left=左半边的第一个元素坐标
        int left = head;
        //right=右半边第一个元素坐标
        int right = mid + 1;
        //临时数组的坐标
        int index = head;

        //第一个循环,如果左右两部分都还有元素
        while (left <= mid && right <= tail) {
            //如果左半部分元素小于右半部分的元素, 在临时数组记录较小的值
            if (nums[left] < nums[right]) {
                temp[index++] = nums[left++];
            }else{
                temp[index++] = nums[right++];
            }
        }
        //第二个循环,如果左半部分还有剩余元素,直接全部加入到临时数组
        while (left <= mid) {
            temp[index++] = nums[left++];
        }
        //第三个循环,如果右半部分还有剩余元素,直接全部加入到临时数组
        while (right <= tail) {
            temp[index++] = nums[right++];
        }
        //第四个循环, 将临时数组中的值复制到原始数组中.
        while (head <= tail) {
            nums[head] = temp[head];
            head++;
        }
    }
}
