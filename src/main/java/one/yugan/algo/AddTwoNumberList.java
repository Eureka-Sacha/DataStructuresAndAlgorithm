package one.yugan.algo;

import one.yugan.DataStructuresCollect;
import one.yugan.structs.ListNode;

/**
 * @author : yugan.
 * @date : 2023/8/21
 * @email : eureka_sacha@outlook.com
 */
public class AddTwoNumberList {
    /**
     * 输入：l1 = [2,4,3], l2 = [5,6,4]
     * 输出：[7,0,8]
     * 解释：342 + 465 = 807.
     * @param nums1
     * @param nums2
     * @return
     */
    public static ListNode addNumberList(ListNode nums1, ListNode nums2) {
        if (nums1 == null) {
            return nums2;
        }
        if (nums2 == null) {
            return nums1;
        }

        int carry = 0;
        ListNode result = new ListNode(0);
        ListNode newhead = result;
        while (nums1 != null && nums2 != null) {
            int val = nums1.val + nums2.val + carry;
            int num = val % 10;
            carry = val / 10;
            newhead.next = new ListNode(num);
            newhead = newhead.next;
            nums1 = nums1.next;
            nums2 = nums2.next;
        }
        while (nums1 != null) {
            int val = nums1.val + carry;
            int num = val % 10;
            carry = val / 10;
            newhead.next = new ListNode(num);
            newhead = newhead.next;
            nums1 = nums1.next;
        }
        while (nums2 != null) {
            int val = nums2.val + carry;
            int num = val % 10;
            carry = val / 10;
            newhead.next = new ListNode(num);
            newhead = newhead.next;
            nums2 = nums2.next;
        }
        if (carry != 0) {
            newhead.next = new ListNode(carry);
        }
        return result.next;
    }

    public static void main(String[] args) {
        ListNode nums1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode nums2 = new ListNode(1, new ListNode(2, new ListNode(9, new ListNode(9))));
        DataStructuresCollect.printListNode(nums1);
        DataStructuresCollect.printListNode(nums2);

        ListNode sum = addNumberList(nums1, nums2);
        DataStructuresCollect.printListNode(sum);

    }
}
