package org.sprintdragon.java.corejava.juc.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangdi on 17-5-11.
 */
public class TestReentrantLock {

    Lock lock = new ReentrantLock();

    public void put(String a) {
        lock.lock();
        try {
            lock.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        TestReentrantLock testReentrantLock = new TestReentrantLock();
        testReentrantLock.put("a");
    }

}
