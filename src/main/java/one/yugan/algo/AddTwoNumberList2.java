package one.yugan.algo;

import one.yugan.DataStructuresCollect;
import one.yugan.structs.ListNode;

/**
 * @author : yugan.
 * @date : 2023/8/21
 * @email : eureka_sacha@outlook.com
 */
public class AddTwoNumberList2 {

    /**
     * 输入：l1 = [7,2,4,3], l2 = [5,6,4]
     * 输出：[7,8,0,7]
     * @param nums1
     * @param nums2
     * @return
     */
    public static ListNode addNumberList(ListNode nums1, ListNode nums2) {
        ListNode r1 = reverse(nums1);
        ListNode r2 = reverse(nums2);
        ListNode r3 = add(r1, r2);
        return reverse(r3);
    }
    public static ListNode reverse(ListNode head){
        return ReverseList.reverse(head);
    }

    public static ListNode add(ListNode nums1, ListNode nums2){
        if (nums1 == null) {
            return nums2;
        }
        if (nums2 == null) {
            return nums1;
        }
        ListNode result = new ListNode(0);
        ListNode head = result;
        int carry = 0;
        while (nums1 != null && nums2 != null) {
            int val = nums1.val + nums2.val + carry;
            int num = val % 10;
            carry = val / 10;
            head.next = new ListNode(num);
            head = head.next;
            nums1 = nums1.next;
            nums2 = nums2.next;
        }
        while (nums1 != null) {
            int val = nums1.val   + carry;
            int num = val % 10;
            carry = val / 10;
            head.next = new ListNode(num);
            head = head.next;
            nums1 = nums1.next;
        }
        while (nums2 != null) {
            int val = nums2.val   + carry;
            int num = val % 10;
            carry = val / 10;
            head.next = new ListNode(num);
            head = head.next;
            nums2 = nums2.next;
        }
        if (carry != 0) {
            head.next = new ListNode(carry);
            head = head.next;
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
