package one.yugan.algo;

import one.yugan.DataStructuresCollect;
import one.yugan.structs.ListNode;

/**
 * @author : yugan.
 * @date : 2023/8/21
 * @email : eureka_sacha@outlook.com
 */
public class ReverseList {
    public static ListNode reverse(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode prev = head;
        ListNode current = head.next;
        prev.next = null;
        while (current != null) {
            ListNode temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }
        return prev;
    }

    public static void main(String[] args) {
        ListNode nums2 = new ListNode(1, new ListNode(2, new ListNode(9, new ListNode(9))));
        DataStructuresCollect.printListNode(nums2);
        ListNode newlist = reverse(nums2);
        DataStructuresCollect.printListNode(newlist);
    }
}
