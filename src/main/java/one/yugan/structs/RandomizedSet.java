package one.yugan.structs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * @author : yugan.
 * @date : 2023/8/20
 * @email : eureka_sacha@outlook.com
 */
public class RandomizedSet {
    List<Integer> list;
    Map<Integer,Integer> map;
    Random random;
    public RandomizedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
        random = new Random();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }
        list.add(val);
        int n = list.size() - 1;
        map.put(val, n);
        return true;
    }

    public boolean remove(int val) {
        if (!map.containsKey(val)) {
            return false;
        }
        //获取当前最后一个元素
        int last = list.get(list.size() - 1);
        //获取准备删除的元素在list的下标
        int n = map.get(val);
        //更新map中当前最后一个元素对应的下标
        map.put(last, n);
        //更新list中准备删除的下标所对应的元素
        list.set(n, last);
        //删除
        map.remove(val);
        //因为已经把last放到下标n了, 所以可以直接删除最后一个元素了
        list.remove(list.size() - 1);
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

}
