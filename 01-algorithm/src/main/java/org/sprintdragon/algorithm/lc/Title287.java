package org.sprintdragon.algorithm.lc;

public class Title287 {

    /**
     * 退化成，寻找循环链表的入口
     *
     * @param nums
     * @return
     */
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        while (true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if (slow == fast) {
                break;
            }
        }
        int finder = 0;
        while (finder != slow) {
            slow = nums[slow];
            finder = nums[finder];
        }
        return finder;
    }

}
