package one.yugan;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.random.RandomGenerator;

import one.yugan.structs.ListNode;
import one.yugan.structs.RandomListNode;

/**
 * @author : yugan.
 * @date : 2023/8/19
 * @email : eureka_sacha@outlook.com
 */
public abstract class DataStructuresCollect {

   public static final List<int[]> INT_ARRAY_COLLECT = new ArrayList<>();

   static {
      INT_ARRAY_COLLECT.add(new int[] {});
      INT_ARRAY_COLLECT.add(new int[] {-1});
      INT_ARRAY_COLLECT.add(new int[] {0});
      INT_ARRAY_COLLECT.add(new int[] {1});
      INT_ARRAY_COLLECT.add(new int[] {1, 1, 2, 2, 3, 3,4,4,5,5,5,5});
      INT_ARRAY_COLLECT.add(new int[] {6, 5, 4, 3, 2, 1});
      INT_ARRAY_COLLECT.add(new int[] {3, -5, 11, 57, -10, 36, 89, 7645});
      INT_ARRAY_COLLECT.add(new int[] {9, 10, 9, 10, 9, 10, 9});
      INT_ARRAY_COLLECT.add(buildRandomBigArray(1000));
      INT_ARRAY_COLLECT.add(buildRandomBigArray(Integer.MAX_VALUE >> 17));
   }

   public static void printListNode(ListNode head) {
      if (head == null) {
         System.out.println("null");
      }
      while (head != null) {
         System.out.printf("%s", head.val);
         head = head.next;
         if (head != null) {
            System.out.print("->");
         }
      }
      System.out.println();
   }

   public static void printRandomListNode(RandomListNode head) {
      if (head == null) {
         System.out.println("null");
      }
      while (head != null) {
         System.out.printf("%s(%s)", head.val, head.random==null?null:head.random.val);
         head = head.next;
         if (head != null) {
            System.out.print("->");
         }
      }
      System.out.println();
   }

   public static int[] buildRandomBigArray(int size) {
      return Random.from(RandomGenerator.getDefault()).ints(size).toArray();
   }

   public static void sortAndPrint(Consumer<int[]> consumer, int[] source) {
      System.out.println("before sort:" + Arrays.toString(source));
      consumer.accept(source);
      System.out.println("after sort:" + Arrays.toString(source));
      System.out.println();
   }

   public static void testAllIntArrayCollect(Consumer<int[]> consumer) {
      long times = LocalDateTime.now().getNano();
      long times2 = System.currentTimeMillis();
      for (int[] ints : INT_ARRAY_COLLECT) {
         sortAndPrint(consumer, ints);
      }
      System.out.printf("cost: %sms/%sns%n",System.currentTimeMillis()-times2, LocalDateTime.now().getNano() - times);
   }
}
