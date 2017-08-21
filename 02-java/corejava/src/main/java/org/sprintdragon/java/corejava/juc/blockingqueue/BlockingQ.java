package org.sprintdragon.java.corejava.juc.blockingqueue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangdi on 17-3-30.
 */
public class BlockingQ {

    private Lock lock = new ReentrantLock();
    private Condition notEmpty = lock.newCondition();
    private Condition notFull = lock.newCondition();
    private Queue<Object> queue = new LinkedList<>();
    private int maxSize = 10;

    public void put(Object object) {
        lock.lock();
        try {
            if (queue.size() == maxSize) {
                notFull.await();
            }
            if (queue.size() == 0) {
                notEmpty.signalAll();
            }
            queue.add(object);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }

    public Object take() {
        lock.lock();
        try {
            if (queue.size() == 0) {
                notEmpty.await();
            }
            if (queue.size() == maxSize) {
                notFull.signalAll();
            }
            return queue.poll();
        } catch (InterruptedException e) {
            e.printStackTrace();
            return null;
        } finally {
            lock.unlock();
        }
    }

}
