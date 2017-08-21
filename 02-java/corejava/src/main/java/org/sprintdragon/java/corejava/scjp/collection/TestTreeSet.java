package org.sprintdragon.java.corejava.scjp.collection;

import java.util.TreeSet;

/**
 * Created by wangdi on 17-8-11.
 */
public class TestTreeSet {

    public static void main(String[] args) {
        TreeSet<Money> monies = new TreeSet<>((o1, o2) -> o1.getCount() - o2.getCount());
        monies.add(new Money());//不传Comparator add时会抛异常
        System.out.println(monies);
    }

}
