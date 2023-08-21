package one.yugan.structs;

/**
 * @author : yugan.
 * @date : 2023/8/21
 * @email : eureka_sacha@outlook.com
 */
public class RandomListNode {
    public int val;
    public RandomListNode next;
    public RandomListNode random;

    public RandomListNode(int val) {
        this.val = val;
    }

    public RandomListNode(int val, RandomListNode next) {
        this.val = val;
        this.next = next;
    }

    public RandomListNode(int val, RandomListNode next, RandomListNode random) {
        this.val = val;
        this.next = next;
        this.random = random;
    }
}
