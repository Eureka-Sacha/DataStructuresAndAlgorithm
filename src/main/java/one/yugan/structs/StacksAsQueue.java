package one.yugan.structs;

import java.util.Stack;

/**
 * @author : yugan.
 * @date : 2023/8/22
 * @email : eureka_sacha@outlook.com
 */
public class StacksAsQueue {

    public static void main(String[] args) {
        StacksAsQueue queue = new StacksAsQueue();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.peek());
        System.out.println(queue.poll());
        System.out.println(queue.poll());
    }

    public Stack<Integer> stack1;
    public Stack<Integer> stack2;

    public StacksAsQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void add(Integer num) {
        stack1.push(num);
    }

    public Integer poll() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return null;
        }
        return stack2.pop();
    }

    public Integer peek() {
        if (stack2.isEmpty()) {
            while (!stack1.isEmpty()) {
                stack2.push(stack1.pop());
            }
        }
        if (stack2.isEmpty()) {
            return null;
        }
        return stack2.peek();
    }
}
