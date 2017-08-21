package org.sprintdragon.java.corejava.juc.lock;

/**
 * Created by wangdi on 17-5-12.
 */
public class TestSync {


    public void get() {
        synchronized (this) {
            try {
                //wait跟notify必须在同步代码块里
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void ss() {
        synchronized (this) {
            this.notify();
        }
    }

    public static void main(String[] args) {
        TestSync testSync = new TestSync();
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                testSync.get();
            }
        });
        t.start();
        try {
            Thread.sleep(2000l);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        testSync.ss();
    }

}
