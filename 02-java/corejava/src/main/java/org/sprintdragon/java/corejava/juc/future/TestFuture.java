package org.sprintdragon.java.corejava.juc.future;

import java.util.concurrent.*;

/**
 * Created by wangdi on 17-8-9.
 */
public class TestFuture {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService exec = Executors.newSingleThreadExecutor();
        Future<Integer> f = exec.submit(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                Thread.sleep(2000l);
                return 2;
            }
        });

        System.out.println(f.isDone()); //False

        System.out.println(f.get()); //Waits until the task is done, then prints 1
        exec.shutdown();
    }

}
