package one.yugan.structs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author : yugan.
 * @date : 2023/8/22
 * @email : eureka_sacha@outlook.com
 */
public class QueuesAsStack {

    public static void main(String[] args) {
        QueuesAsStack queuesAsStack = new QueuesAsStack();
        queuesAsStack.push(1);
        queuesAsStack.push(2);
        queuesAsStack.push(3);
        System.out.println(queuesAsStack.pop());
        System.out.println(queuesAsStack.pop());
        System.out.println(queuesAsStack.pop());
    }
    public Queue<Integer> queue1;
    public Queue<Integer> queue2;

    public QueuesAsStack() {
        queue1 = new ArrayDeque<>();
        queue2 = new ArrayDeque<>();
    }

    public void push(Integer num) {
        queue2.add(num);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }

    public Integer pop(){
        return queue1.poll();
    }

    public Integer peek() {
        return queue1.peek();
    }
}
