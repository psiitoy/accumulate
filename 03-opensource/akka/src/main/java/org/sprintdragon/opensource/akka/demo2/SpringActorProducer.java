package org.sprintdragon.opensource.akka.demo2;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;
import org.springframework.context.ApplicationContext;

/**
 * IndirectActorProducer接口
 * IndirectActorProducer是Akka提供的Actor生成接口，从其名字我们知道Akka给我们指出了另一条道路——石头大了绕着走！
 * 通过实现IndirectActorProducer接口我们可以定制一些Actor的生成方式，与Spring集成可以这样实现它，见代码清单2所示。
 * Created by wangdi on 17-8-15.
 */
public class SpringActorProducer implements IndirectActorProducer {
    private final ApplicationContext applicationContext;
    private final String actorBeanName;
    private final Object[] args;

    public SpringActorProducer(ApplicationContext applicationContext, String actorBeanName, Object... args) {
        this.applicationContext = applicationContext;
        this.actorBeanName = actorBeanName;
        this.args = args;
    }

    public Actor produce() {
        return (Actor) applicationContext.getBean(actorBeanName, args);
    }

    public Class<? extends Actor> actorClass() {
        return (Class<? extends Actor>) applicationContext.getType(actorBeanName);
    }
}