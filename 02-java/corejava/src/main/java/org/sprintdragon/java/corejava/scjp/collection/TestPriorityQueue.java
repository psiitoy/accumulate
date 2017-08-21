package org.sprintdragon.java.corejava.scjp.collection;

import java.util.PriorityQueue;

/**
 * Created by wangdi on 17-8-11.
 */
public class TestPriorityQueue {

    public static void main(String[] args) {
        PriorityQueue<Money> monies = new PriorityQueue<>();
        monies.add(new Money());
        System.out.println(monies);
        monies.poll();
    }

}
