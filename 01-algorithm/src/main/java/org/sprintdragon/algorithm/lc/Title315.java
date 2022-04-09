package org.sprintdragon.algorithm.lc;

import java.util.ArrayList;
import java.util.List;

public class Title315 {

    /**
     * todo 索引数组这块没理解先跳过这题
     * 补一份java实现，我觉得我写的挺好懂的，分步骤说下思路
     * <p>
     * 首先这是逆序数的变形，但是逆序数可以对原数组排序，但是这个不可以，因为需要求解数组中每一个元素的逆序数，如果排序，就乱了
     * 那么该怎么办？根据值对下标排序就好了，原数组不变
     * 下标归并排序的过程中，如果前面下标对应的值大于后面下标对应的值，则需要前面的下标到最后的count++ （这里说不清楚，看代码应该能明白）
     */
    int[] count;
    int[] index;
    int[] nums;

    public List<Integer> countSmaller(int[] nums) {
        int N = nums.length;
        if (N == 0) return new ArrayList<Integer>();
        count = new int[N];
        index = new int[N];
        this.nums = nums;
        for (int i = 0; i < N; i++) index[i] = i;
        sort(0, N - 1);
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < N; i++) res.add(count[i]);
        return res;
    }

    public void sort(int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        sort(left, mid);
        sort(mid + 1, right);
        merge(left, mid, right);
    }

    public void merge(int left, int mid, int right) {
        int[] index1 = new int[mid - left + 1];
        int[] index2 = new int[right - mid];
        for (int i = 0; i < index1.length; i++) index1[i] = index[left + i];
        for (int i = 0; i < index2.length; i++) index2[i] = index[mid + 1 + i];
        int k = left;
        int i = 0, j = 0;
        while (i < index1.length && j < index2.length) {
            if (nums[index1[i]] > nums[index2[j]]) {
                index[k++] = index2[j++];
                for (int l = i; l < index1.length; l++)
                    count[index1[l]]++;
            } else index[k++] = index1[i++];
        }
        while (i < index1.length) index[k++] = index1[i++];
        while (j < index2.length) index[k++] = index2[j++];
    }
}
