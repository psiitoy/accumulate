package org.sprintdragon.algorithm.lc;

import java.util.Arrays;

public class Title621 {

    /**
     * 1. 如果有大任务需要等待，需要空转的场景只和最大的任务自身有关
     * 2. 如果很多任务都很大，那么并发执行就好，不会涉及空转，即直接取任务数
     * 3. 最后一轮最大的任务跑即可结束，不需要等待空转
     * 4. 要计算可能同时存在多种最大任务
     * 5. 直接用char-'A'放下标排序，拿到最大任务
     *
     * @param tasks
     * @param n
     * @return
     */
    public int leastInterval(char[] tasks, int n) {
        int longestTaskType = 1;
        int[] buket = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            buket[tasks[i] - 'A']++;
        }
        Arrays.sort(buket);
        for (int i = buket.length - 1; i > 0; i--) {
            if (buket[i] == buket[i - 1]) {
                longestTaskType++;
            } else {
                break;
            }
        }
        int res = (buket[25] - 1) * (n + 1) + longestTaskType;
        return Math.max(tasks.length, res);
    }

}
