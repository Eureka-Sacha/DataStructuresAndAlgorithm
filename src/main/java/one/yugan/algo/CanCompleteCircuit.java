package one.yugan.algo;

import java.util.Arrays;

/**
 * @author : yugan.
 * @date : 2023/8/23
 * @email : eureka_sacha@outlook.com
 */
public class CanCompleteCircuit {
    public static void main(String[] args) {
        int[] gas = {1, 2, 3, 4, 5};
        int[] cost = {3, 4, 5, 1, 2};
        System.out.println(Arrays.toString(gas));
        System.out.println(Arrays.toString(cost));
        System.out.println(canCompleteCircuit(gas, cost));
    }

    /**
     * 134. 加油站
     *
     * 在一条环路上有 n 个加油站，其中第 i 个加油站有汽油 gas[i] 升。
     * 你有一辆油箱容量无限的的汽车，从第 i 个加油站开往第 i+1 个加油站需要消耗汽油 cost[i] 升。你从其中的一个加油站出发，开始时油箱为空。
     * 给定两个整数数组 gas 和 cost ，如果你可以按顺序绕环路行驶一周，则返回出发时加油站的编号，否则返回 -1 。如果存在解，则 保证 它是 唯一 的。
     *
     * 输入: gas = [1,2,3,4,5], cost = [3,4,5,1,2]
     * 输出: 3
     * 解释:
     * 从 3 号加油站(索引为 3 处)出发，可获得 4 升汽油。此时油箱有 = 0 + 4 = 4 升汽油
     * 开往 4 号加油站，此时油箱有 4 - 1 + 5 = 8 升汽油
     * 开往 0 号加油站，此时油箱有 8 - 2 + 1 = 7 升汽油
     * 开往 1 号加油站，此时油箱有 7 - 3 + 2 = 6 升汽油
     * 开往 2 号加油站，此时油箱有 6 - 4 + 3 = 5 升汽油
     * 开往 3 号加油站，你需要消耗 5 升汽油，正好足够你返回到 3 号加油站。
     * 因此，3 可为起始索引。
     */
    public static int canCompleteCircuit(int[] nums, int[] cost) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (cost == null || cost.length == 0) {
            return -1;
        }
        if (nums.length != cost.length) {
            return -1;
        }
        //总油量如果小于耗油量,一定不会有结果.
        if (Arrays.stream(nums).sum() < Arrays.stream(cost).sum()) {
            return -1;
        }
        int index = -1;
        for (int i = 0; i < nums.length; i++) {
            if (remainGas(nums, cost, i)) {
                //如果要求只能有一个结果, 那就在这里判断
                if (index != -1) {
                    return -1;
                }
                index = i;
            }

        }
        return index;
    }

    public static boolean remainGas(int[] gas, int[] cost, int pos) {
        int remain = gas[pos] - cost[pos];
        if (remain < 0) {
            return false;
        }
        int start = pos + 1;
        while (start != pos) {
            if (start >= gas.length ) {
                start = 0;
            }
            remain += gas[start];
            remain -= cost[start];
            if (remain < 0) {
                return false;
            }
            start++;
        }
        return true;
    }
}
