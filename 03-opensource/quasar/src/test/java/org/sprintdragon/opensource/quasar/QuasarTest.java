package org.sprintdragon.opensource.quasar;

import co.paralleluniverse.fibers.Fiber;
import org.junit.Test;

/**
 * -javaagent:/home/wangdi/IdeaWorkspace/psiitoy/accumulate/03-opensource/quasar/target/quasar-1.0-SNAPSHOT/lib/quasar-core-0.7.5-jdk8.jar
 * Created by wangdi on 17-8-24.
 */
public class QuasarTest {

    @Test
    public void testHello() throws Exception {
        long count = 0;
        while (true) {
            Fiber<Void> fiber = new Fiber<Void>(() ->
                    Fiber.sleep(2000)).start();
            count++;
            if (count == 10000) {
                System.out.println("finish!!");
                break;
            }
        }
    }

//    @Test
//    public void testThread() throws Exception {
//        long count = 0;
//        while (true) {
//            new Thread(() -> {
//                try {
//                    Thread.sleep(2000l);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            }).start();
//            count++;
//            if (count == 10000) {
//                System.out.println("finish!!");
//                break;
//            }
//        }
//    }
}
