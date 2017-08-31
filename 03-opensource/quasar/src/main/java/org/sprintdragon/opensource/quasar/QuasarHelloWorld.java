package org.sprintdragon.opensource.quasar;

import co.paralleluniverse.fibers.Fiber;
import co.paralleluniverse.fibers.SuspendExecution;

/**
 * Created by wangdi on 17-8-24.
 */
public class QuasarHelloWorld {

    public static void main(String[] args) {
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

}
