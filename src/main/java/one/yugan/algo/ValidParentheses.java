package one.yugan.algo;

import java.util.Stack;

/**
 * @author : yugan.
 * @date : 2023/8/22
 * @email : eureka_sacha@outlook.com
 */
public class ValidParentheses {

    public static void main(String[] args) {
        String str = "[[]][[]]";
        System.out.println(str);
        System.out.println(isValid(str));
        str = "{}[]{}";
        System.out.println(str);
        System.out.println(isValid(str));
        str = "[{][}]";
        System.out.println(str);
        System.out.println(isValid(str));
        str = "{(]}";
        System.out.println(str);
        System.out.println(isValid(str));

    }

    public static boolean isValid(String string) {
        if (string == null || string.isBlank()) {
            return true;
        }
        char[][] pars = {{'{', '}'}, {'[', ']'}, {'(', ')'}};
        Stack<Character> stack = new Stack<>();
        for (char[] par : pars) {
            for (char c : string.toCharArray()) {
                if (c == par[0]) {
                    stack.push(par[0]);
                }
                if (c == par[1]) {
                    if (stack.isEmpty()||stack.pop() != par[0]) {
                        return false;
                    }
                }
            }
        }
        return stack.isEmpty();
    }
}
