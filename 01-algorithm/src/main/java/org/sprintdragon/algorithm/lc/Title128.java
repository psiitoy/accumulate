package org.sprintdragon.algorithm.lc;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Title128 {

    public static void main(String[] args) {
        Title128 test = new Title128();
        int[] a = {1, -8, 7, -2, -4, -4, 6, 3, -4, 0, -7, -1, 5, 1, -9, -3};
        System.out.println(test.longestConsecutive(a));
    }

    /**
     * 并查集方式，注意使用了int进行去重
     */
    class UniqueFind {
        Map<Integer, Integer> findMap;
        Map<Integer, Integer> sizeMap;
        int max = 1;

        public UniqueFind(int[] nums) {
            findMap = new HashMap<>(nums.length);
            sizeMap = new HashMap<>(nums.length);
            for (int n : nums) {
                findMap.put(n, n);
                sizeMap.put(n, 1);
            }
        }

        public Integer find(int son) {
            int parent = findMap.get(son);
            if (parent != son) {
                parent = find(parent);
            }
            findMap.put(son, parent);
            return parent;
        }

        public void union(int a, int b) {
            int parentA = find(a);
            int parentB = find(b);
            if (parentA != parentB) {
                int sizeA = sizeMap.get(parentA);
                int sizeB = sizeMap.get(parentB);
                if (sizeA > sizeB) {
                    findMap.put(parentB, parentA);
                    sizeMap.put(parentA, sizeA + sizeB);
                } else {
                    findMap.put(parentA, parentB);
                    sizeMap.put(parentB, sizeA + sizeB);
                }
                max = Math.max(max, sizeA + sizeB);
            }
        }

    }

    public int longestConsecutive(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        UniqueFind uf = new UniqueFind(nums);
        for (int n : nums) {
            if (uf.findMap.containsKey(n - 1)) {
                uf.union(n, n - 1);
            }
        }
        return uf.max;
    }

    /**
     * 官方解法，注意可以用set去重，减少遍历次数
     *
     * @param nums
     * @return
     */
    public int longestConsecutiveLc(int[] nums) {
        Set<Integer> set = new HashSet<>(nums.length);
        for (int n : nums) {
            set.add(n);
        }
        int maxCount = 0;
        for (int val : set) {
            if (!set.contains(val - 1)) {
                int count = 0;
                while (set.contains(val)) {
                    count++;
                    val++;
                }
                maxCount = Math.max(count, maxCount);
            }
        }
        return maxCount;
    }
}
