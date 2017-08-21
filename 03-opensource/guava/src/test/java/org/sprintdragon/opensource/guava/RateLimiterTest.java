package org.sprintdragon.opensource.guava;

import com.google.common.util.concurrent.RateLimiter;
import org.junit.Test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by wangdi on 16-10-19.
 */
public class RateLimiterTest {
    AtomicInteger count = new AtomicInteger();
    final RateLimiter rateLimiter = RateLimiter.create(1);
    ExecutorService executor = Executors.newFixedThreadPool(5);

    @Test
    public void testAcquire() throws Exception {
        Thread.sleep(5000);
        for (int i = 0; i < 5; i++) {
            executor.submit(new Runnable() {
                public void run() {
                    while (true){
                        System.out.println(count.addAndGet(1) + ",cost=" + rateLimiter.acquire());
                    }
                }
            });
        }
        Thread.sleep(2000000);
    }

    @Test
    public void testTryAcquire() throws Exception {
        RateLimiter rateLimiter = RateLimiter.create(2);

        int count = 0;
        while (true) {
            if (rateLimiter.tryAcquire()) {
                System.out.println(++count);
            } else {
                System.out.println("wait....");
            }
            Thread.sleep(200);
        }
    }
}
