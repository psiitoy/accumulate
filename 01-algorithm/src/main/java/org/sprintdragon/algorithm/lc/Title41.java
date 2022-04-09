package org.sprintdragon.algorithm.lc;

public class Title41 {

    public static void main(String[] args) {
        Title41 test = new Title41();
        int[] a = {1, 1};
        System.out.println(test.firstMissingPositive(a));
    }

    /**
     * 原地hash
     * hard 看题解才会
     * 1. 记着swap a b不能一样不然会一直交换死循环
     *
     * @param nums
     * @return
     */
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            while (nums[i] > 0 && nums[i] <= len && nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                swap(nums, i, nums[i] - 1);
            }
        }
        for (int i = 0; i < len; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }

    private void swap(int[] nums, int a, int b) {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }

}
