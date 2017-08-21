package org.sprintdragon.java.corejava.kaiyuan.stack;

/**
 * Created by wangdi on 17-5-23.
 */
public class TestStack {

    public void testSpeed() {
        MyStack<Integer> stack = new MyArrayStack<Integer>();
        int num = 10000000;
        long start = System.currentTimeMillis();
        for (int i = 0; i < num; i++) {
            stack.push(i);
        }
        long temp = System.currentTimeMillis();
        System.out.println("push time: " + (temp - start));
        while (stack.pop() != null)
            ;
        System.out.println("pop time: " + (System.currentTimeMillis() - temp));
    }

}
