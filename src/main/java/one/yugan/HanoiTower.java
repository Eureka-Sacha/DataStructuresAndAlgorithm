package one.yugan;

import java.util.LinkedList;
import java.util.List;

/**
 * @author : yugan.
 * @date : 2023/8/19
 * @email : eureka_sacha@outlook.com
 */
public class HanoiTower {

    public static LinkedList<Integer> a = new LinkedList<>();
    public static LinkedList<Integer> b = new LinkedList<>();
    public static LinkedList<Integer> c = new LinkedList<>();

    public static void init(int n) {
        for (int i = n; i > 0; i--) {
            a.add(i);
        }
    }

    public static void hanoiTower(int num) {
        init(num);
        print(a, b, c);
        move(num, a, b, c);
        print(a, b, c);
    }

    private static void print(List<Integer> a, List<Integer> b, List<Integer> c) {
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println();
    }

    private static void move(int n, LinkedList<Integer> a, LinkedList<Integer> b, LinkedList<Integer> c) {
        if (n == 0) {
            return;
        }

        move(n - 1, a, c, b);
        c.addLast(a.removeLast());
        print(HanoiTower.a,HanoiTower.b,HanoiTower.c);
        move(n - 1, b, a, c);
    }

    public static void main(String[] args) {
        hanoiTower(3);
    }

}
