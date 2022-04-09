package org.sprintdragon.algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Title78 {

    public static void main(String[] args) {
        Title78 test = new Title78();
        int[] nums = {1, 2};
        System.out.println(test.subsets(nums));
    }

    List<List<Integer>> res = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0, new ArrayList<>(nums.length));
        return res;
    }

    public void backtrack(int[] nums, int index, List<Integer> buf) {
        if (index == nums.length) {
            res.add(new ArrayList<>(buf));
            return;
        }
        buf.add(nums[index]);
        backtrack(nums, index + 1, buf);
        buf.remove(buf.size() - 1);
        backtrack(nums, index + 1, buf);
    }

}
