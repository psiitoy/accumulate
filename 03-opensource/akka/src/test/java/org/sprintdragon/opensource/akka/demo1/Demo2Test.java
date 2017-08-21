package org.sprintdragon.opensource.akka.demo1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Inbox;
import akka.util.Timeout;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.sprintdragon.opensource.akka.demo2.CountingActor;
import org.sprintdragon.opensource.akka.demo2.Demo2Application;
import org.sprintdragon.opensource.akka.demo2.SpringExt;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.FiniteDuration;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static akka.pattern.Patterns.ask;

/**
 * Created by wangdi on 17-8-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Demo2Application.class)
public class Demo2Test {

    @Resource
    private ActorSystem actorSystem;

    @Resource
    private SpringExt springExt;

    @Test
    public void testHello() throws Exception {
        ActorRef counter = actorSystem.actorOf(springExt.props("CountingActor"), "counter");

// Create the "actor-in-a-box"
        final Inbox inbox = Inbox.create(actorSystem);

// tell it to count three times
        inbox.send(counter, new CountingActor.Count());
        inbox.send(counter, new CountingActor.Count());
        inbox.send(counter, new CountingActor.Count());

// print the result
        FiniteDuration duration = FiniteDuration.create(3, TimeUnit.SECONDS);
        Future<Object> result = ask(counter, new CountingActor.Get(), Timeout.durationToTimeout(duration));
        try {
            System.out.println("Got back " + Await.result(result, duration));
        } catch (Exception e) {
            System.err.println("Failed getting result: " + e.getMessage());
            throw e;
        }
    }
}
