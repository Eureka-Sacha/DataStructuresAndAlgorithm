package one.yugan.structs;

import java.util.EmptyStackException;
import java.util.Stack;

/**
 * @author : yugan.
 * @date : 2023/8/22
 * @email : eureka_sacha@outlook.com
 */
public class MinStack {

    public static void main(String[] args) {
        MinStack mStack = new MinStack();
        mStack.push(1);
        mStack.push(2);
        mStack.push(3);
        System.out.println(mStack.min());
        System.out.println(mStack.pop());
        System.out.println(mStack.min());
        System.out.println(mStack.pop());
        System.out.println(mStack.min());
    }

    public Stack<Integer> stack;
    public Stack<Integer> minStack;

    public MinStack() {
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(Integer integer) {
        if (!minStack.isEmpty()) {
            Integer n = minStack.peek();
            if (n > integer) {
                minStack.push(integer);
            }else{
                minStack.push(n);
            }
        }else{
            minStack.push(integer);
        }
        stack.push(integer);
    }

    public Integer pop() {
        minStack.pop();
        return stack.pop();
    }

    public Integer min(){
        if (!minStack.isEmpty()) {
            return minStack.peek();
        }
        throw new EmptyStackException();
    }
}
