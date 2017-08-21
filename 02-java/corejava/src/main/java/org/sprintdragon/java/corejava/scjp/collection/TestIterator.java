package org.sprintdragon.java.corejava.scjp.collection;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by wangdi on 17-5-11.
 */
public class TestIterator {

    public static void main(String[] args) {
        arraylistIt();
    }

    public static void arraylistIt() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer a = it.next();
            if (a == 3) {
                it.remove();
            }
        }
        System.out.println(list);
    }

    public static void linklistIt() {
        List<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        Iterator<Integer> it = list.iterator();
        while (it.hasNext()) {
            Integer a = it.next();
            if (a == 3) {
                it.remove();
            }
        }
        System.out.println(list);
    }

}
