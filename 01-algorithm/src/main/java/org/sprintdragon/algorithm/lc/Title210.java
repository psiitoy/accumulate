package org.sprintdragon.algorithm.lc;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Title210 {

    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        int[] depends = new int[numCourses];
        for (int[] pair : prerequisites) {
            edges.get(pair[1]).add(pair[0]);
            depends[pair[0]]++;
        }
        Queue<Integer> canStudy = new LinkedList<>();
        for (int i = 0; i < depends.length; i++) {
            if (depends[i] == 0) {
                canStudy.offer(i);
            }
        }
        int[] order = new int[numCourses];
        int index = 0;
        while (!canStudy.isEmpty()) {
            Integer course = canStudy.poll();
            order[index++] = course;
            for (int v : edges.get(course)) {
                depends[v]--;
                if (depends[v] == 0) {
                    canStudy.offer(v);
                }
            }
        }
        if (index == numCourses) {
            return order;
        } else {
            return new int[0];
        }
    }

}
