package org.sprintdragon.algorithm.lc;

import java.util.*;

public class Title380 {

    public static void main(String[] args) {
        // 初始化一个空的集合。
        RandomizedSet randomSet = new RandomizedSet();
        randomSet.remove(0);
        randomSet.remove(0);
        randomSet.insert(0);
        randomSet.getRandom();
        randomSet.remove(0);
        randomSet.insert(0);
//
//// 向集合中插入 1 。返回 true 表示 1 被成功地插入。
//        boolean a = randomSet.insert(1);
//        System.out.println(a);
//// 返回 false ，表示集合中不存在 2 。
//        a = randomSet.remove(2);
//        System.out.println(a);
//// 向集合中插入 2 。返回 true 。集合现在包含 [1,2] 。
//        a = randomSet.insert(2);
//        System.out.println(a);
//// getRandom 应随机返回 1 或 2 。
//        int v = randomSet.getRandom();
//        System.out.println(v);
//// 从集合中移除 1 ，返回 true 。集合现在包含 [2] 。
//        a = randomSet.remove(1);
//        System.out.println(a);
//// 2 已在集合中，所以返回 false 。
//        a = randomSet.insert(2);
//        System.out.println(a);
//// 由于 2 是集合中唯一的数字，getRandom 总是返回 2 。
//        v = randomSet.getRandom();
//        System.out.println(v);
    }

    static class RandomizedSet {
        HashMap<Integer, Integer> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int endPoint = 0;

        /**
         * Initialize your data structure here.
         */
        public RandomizedSet() {
        }

        /**
         * Inserts a value to the set. Returns true if the set did not already contain the specified element.
         */
        public boolean insert(int val) {
            if (!map.containsKey(val)) {
                map.put(val, endPoint++);
                list.add(val);
                return true;
            } else {
                return false;
            }
        }

        /**
         * Removes a value from the set. Returns true if the set contained the specified element.
         */
        public boolean remove(int val) {
            if (map.containsKey(val)) {
                int index = map.remove(val);
                int tmp = list.remove(--endPoint);
                if (index != endPoint) {
                    list.set(index, tmp);
                    map.put(tmp, index);
                }
                return true;
            } else {
                return false;
            }
        }

        /**
         * Get a random element from the set.
         */
        public int getRandom() {
            int ran = new Random().nextInt(endPoint);
            return list.get(ran);
        }
    }

}
