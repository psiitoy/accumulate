package org.sprintdragon.opensource.akka.demo2;

import akka.actor.UntypedActor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * CountingActor（代码主体借用自Akka官网）是用于计数的Actor，见代码清单1所示。
 * CountingActor通过注解方式注入了CountingService，CountingActor的计数实际是由CountingService完成。
 * 细心的同学可能发现了CountingActor使用了注解Named，这里为什么没有使用@Service或者@Component等注解呢？
 * 由于Akka的Actor在初始化的时候必须使用System或者Context的工厂方法actorOf创建新的Actor实例，不
 * 能使用构造器来初始化，而使用Spring的Service或者Component注解，会导致使用构造器初始化Actor，所以会抛出以下异常：ActorInitializationException
 * Created by wangdi on 17-8-15.
 */
@Component("CountingActor")
@Scope("prototype")
public class CountingActor extends UntypedActor {

    public static class Count {
    }

    public static class Get {
    }

    // the service that will be automatically injected
    @Resource
    private CountingService countingService;

    private int count = 0;

    @Override
    public void onReceive(Object message) throws Exception {
        if (message instanceof Count) {
            count = countingService.increment(count);
        } else if (message instanceof Get) {
            getSender().tell(count, getSelf());
        } else {
            unhandled(message);
        }
    }
}