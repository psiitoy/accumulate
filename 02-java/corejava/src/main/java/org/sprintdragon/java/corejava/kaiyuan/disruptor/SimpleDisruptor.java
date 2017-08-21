package org.sprintdragon.java.corejava.kaiyuan.disruptor;

/**
 * Created by wangdi on 17-5-22.
 */
public class SimpleDisruptor {

    volatile int readBarrier;
    Object[] ring = new Object[1024];

    class Producer {
        int writeCount;

        void produce(Object newItem) {
            ring[++writeCount % ring.length] = newItem;
        }
    }

    class Consumer {

        void run() {
            int currentRead = 0;
            while (true) {
                if (readBarrier > currentRead) {
                    consume(currentRead);
                    currentRead++;
                }
            }
        }

        private void consume(int currentRead) {
            System.out.println("##" + ring[currentRead % ring.length]);
        }
    }

}
