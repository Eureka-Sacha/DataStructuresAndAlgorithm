package one.yugan.algo;

import java.util.Random;

import one.yugan.DataStructuresCollect;
import one.yugan.structs.RandomListNode;

/**
 * @author : yugan.
 * @date : 2023/8/21
 * @email : eureka_sacha@outlook.com
 */
public class DepCopyRandomList2 {
    public static RandomListNode depCopyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);
        return split(head);
    }

    public static void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode node = new RandomListNode(head.val);
            RandomListNode next = head.next;
            head.next = node;
            node.next = next;
            head = next;
        }
    }

    public static void copyRandom(RandomListNode head) {
        while (head != null) {
            RandomListNode random = head.random;
            if (random != null) {
                head.next.random = random.next;
            }
            head = head.next.next;
        }
    }

    public static RandomListNode split(RandomListNode head) {
        RandomListNode newHead = head.next;
        while (head != null) {
            RandomListNode temp = head.next;
            head.next = temp.next;
            head = head.next;
            if (temp.next != null) {
                temp.next = temp.next.next;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        RandomListNode list = new RandomListNode(1,
            new RandomListNode(2,
                new RandomListNode(3,
                    new RandomListNode(4))));
        list.random = list.next.next;
        list.next.random = list;
        list.next.next.next.random = list;
        System.out.println(list);
        DataStructuresCollect.printRandomListNode(list);
        RandomListNode newList = depCopyRandomList(list);
        System.out.println(newList);
        DataStructuresCollect.printRandomListNode(newList);
    }
}
