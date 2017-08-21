package org.sprintdragon.java.corejava.scjp.collection;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangdi on 17-5-19.
 */
public class TestArrayList {

    public static void main(String[] args) {
        List<Integer> ls = new ArrayList<Integer>();

        ls.add(1);
        ls.add(2);
        ls.add(3);
        System.out.println(ls.toString());

        for (Integer in : ls) {
            if (in == 3) {//in==2时，正常执行
                ls.remove(in);
            }
        }
        System.out.println(ls.toString());
    }

}
