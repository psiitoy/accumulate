package org.sprintdragon.java.corejava.juc;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wangdi on 17-4-26.
 */
public class TestAdd {

    public static int x = 0;
    public static AtomicInteger ai = new AtomicInteger();


    public static void main(String[] args) {
        add();
        addSync();
        thread2Add();
        thread2AddSync();
        addAt();
        thread2AddAt();
    }

    public static void thread2AddAt() {
        CountDownLatch latch = new CountDownLatch(2);
        long time = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (ai.get() < 1000000000) {
                            ai.incrementAndGet();
                        } else {
                            break;
                        }
                    }
                    latch.countDown();
                }
            });
            t.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread2AddAt ai=" + ai.intValue() + ",cost=" + (System.currentTimeMillis() - time));
        ai.set(0);
    }

    public static void addAt() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            ai.incrementAndGet();
        }
        System.out.println("addAt ai=" + ai.intValue() + ",cost=" + (System.currentTimeMillis() - time));
        ai.set(0);
    }

    public static void thread2Add() {
        CountDownLatch latch = new CountDownLatch(2);
        long time = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        if (x < 1000000000) {
                            x++;
                        } else {
                            break;
                        }
                    }
                    latch.countDown();
                }
            });
            t.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread2Add x=" + x + ",cost=" + (System.currentTimeMillis() - time));
        x = 0;
    }

    public static void thread2AddSync() {
        CountDownLatch latch = new CountDownLatch(2);
        long time = System.currentTimeMillis();
        for (int i = 0; i < 2; i++) {
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    while (true) {
                        synchronized (TestAdd.class) {
                            if (x < 1000000000) {
                                x++;
                            } else {
                                break;
                            }
                        }
                    }
                    latch.countDown();
                }
            });
            t.start();
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("thread2AddSync x=" + x + ",cost=" + (System.currentTimeMillis() - time));
        x = 0;
    }

    public static void add() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            x++;
        }
        System.out.println("add x=" + x + ",cost=" + (System.currentTimeMillis() - time));
        x = 0;
    }

    public static void addSync() {
        long time = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) {
            synchronized (TestAdd.class) {
                x++;
            }
        }
        System.out.println("addSync x=" + x + ",cost=" + (System.currentTimeMillis() - time));
        x = 0;
    }

}
