package org.sprintdragon.opensource.akka.demo1;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * Created by wangdi on 17-8-15.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = Demo1Application.class)
public class Demo1Test {

    @Resource
    ActorSystem actorSystem;

    @Test
    public void testHello() throws Exception {
        ActorRef a = actorSystem.actorOf(Props.create(HelloWorld.class), "helloWorld");

    }
}
