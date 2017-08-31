package org.sprintdragon.java.corejava.juc.forkjoin.forkjoinpool.demo1;

import java.util.concurrent.RecursiveTask;

/**
 * Created by wangdi on 17-8-23.
 */
@SuppressWarnings("serial")
public class MyTask extends RecursiveTask<Integer> {
    int i;

    public MyTask(int i) {
        this.i = i;
    }

    @Override
    protected Integer compute() {
        if (i >= 100) {
            return i * i;
        }

        MyTask newTask2 = new MyTask(i + 1);
        newTask2.fork();

        return i * i + newTask2.join();

    }

}