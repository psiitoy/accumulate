package org.sprintdragon.opensource.springbatch;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by wangdi on 16-9-5.
 */
public class TestBatchExtendArrayBlockQ {

    public static void main(String[] args) {

        MyArrayBlockQueue blockingQueue = new MyArrayBlockQueue(10, TimeUnit.SECONDS, 10, 300);
        Thread thread = new Thread(new Producer(blockingQueue));
        Thread thread1 = new Thread(new Consumer(blockingQueue));

        thread.start();
        thread1.start();


    }


    static class Producer implements Runnable {

        private MyArrayBlockQueue blockingQueue;


        public Producer(MyArrayBlockQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000l);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                blockingQueue.put(new ArrayList<Object>() {{
                    add(UUID.randomUUID());
                }});
                System.out.println("produce put :");
            }

        }
    }

    static class Consumer implements Runnable {

        private MyArrayBlockQueue blockingQueue;

        public Consumer(MyArrayBlockQueue blockingQueue) {
            this.blockingQueue = blockingQueue;
        }

        @Override
        public void run() {

            while (true) {
                System.out.println("consumer :" + blockingQueue.takeList());
            }

        }
    }


}

class MyArrayBlockQueue extends ArrayBlockingQueue {

    private TimeUnit timeUnit;

    private int threshold;

    private long time;


    public MyArrayBlockQueue(int capacity, TimeUnit timeUnit, long time, int threshold) {
        super(capacity);
        this.timeUnit = timeUnit;
        this.threshold = threshold;
        this.time = time;
    }


    private ReentrantLock reentrantLock = new ReentrantLock();
    private Condition condition = reentrantLock.newCondition();

    public void put(List<Object> o) {
        reentrantLock.lock();
        for (Object obj : o) {
            try {
                super.put(obj);
                if (super.size() >= threshold) {
                    condition.signalAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        reentrantLock.unlock();

    }

    public List<Object> takeList() {
        reentrantLock.lock();
        List<Object> mylist = new ArrayList<Object>();
        try {
            condition.await(time, timeUnit);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Object object = new Object();
        while (null != (object = super.poll())) {
            mylist.add(object);
        }
        reentrantLock.unlock();
        return mylist;
    }
}