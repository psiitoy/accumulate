package org.sprintdragon.java.corejava.juc.forkjoin.forkjoinpool.demo1;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.Future;

/**
 * Created by wangdi on 17-8-23.
 */
public class MainTest {

    public static void main(String[] args) {
        MyTask mt = new MyTask(1);

        ForkJoinPool forkJoinPool = new ForkJoinPool();

        Future<Integer> result = forkJoinPool.submit(mt);

        try {
            System.out.println(result.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        forkJoinPool.shutdown();
    }

}
