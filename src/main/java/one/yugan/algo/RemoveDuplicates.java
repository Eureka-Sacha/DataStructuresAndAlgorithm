package one.yugan.algo;

import one.yugan.DataStructuresCollect;

/**
 * @author : yugan.
 * @date : 2023/8/20
 * @email : eureka_sacha@outlook.com
 */
public class RemoveDuplicates {
    public static int removeDuplicates(int[] nums) {
        int step = 2;
        if(nums == null || nums.length == 0) return 0;
        if (nums.length <= step) {
            return nums.length;
        }
        int first = step;
        int secend = step;
        while(secend < nums.length){
            if(nums[first-step] != nums[secend]){
                nums[first] = nums[secend];
                first++;
            }
            secend++;
        }
        return first;
    }

    public static void main(String[] args) {
        DataStructuresCollect.testAllIntArrayCollect(RemoveDuplicates::removeDuplicates);
    }
}
