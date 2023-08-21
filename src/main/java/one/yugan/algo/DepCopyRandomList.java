package one.yugan.algo;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import one.yugan.DataStructuresCollect;
import one.yugan.structs.RandomListNode;

/**
 * @author : yugan.
 * @date : 2023/8/21
 * @email : eureka_sacha@outlook.com
 */
public class DepCopyRandomList {
    public static RandomListNode depCopyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }

        Map<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode newHead = head;
        while (newHead != null) {
            RandomListNode newNode ;
            if (map.containsKey(newHead)) {
                newNode = map.get(newHead);
            }else{
                newNode = new RandomListNode(newHead.val);
                map.put(newHead, newNode);
            }
            RandomListNode next = newHead.next;
            if (next != null) {
                if (map.containsKey(next)) {
                    newNode.next = map.get(next);
                }else{
                    RandomListNode newNext = new RandomListNode(next.val);
                    newNode.next = newNext;
                    map.put(next, newNext);
                }
            }
            RandomListNode random = newHead.random;
            if (random != null) {
                if (map.containsKey(random)) {
                    newNode.random = map.get(random);
                }else{
                    RandomListNode newRandom = new RandomListNode(random.val);
                    newNode.random = newRandom;
                    map.put(random, newRandom);
                }
            }
            newHead = newHead.next;
        }

        return map.get(head);
    }

    public static void main(String[] args) {
        RandomListNode list = new RandomListNode(1,
            new RandomListNode(2, new RandomListNode(3, new RandomListNode(4))));
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
