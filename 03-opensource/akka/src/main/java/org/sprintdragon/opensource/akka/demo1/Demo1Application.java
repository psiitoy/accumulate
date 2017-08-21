package org.sprintdragon.opensource.akka.demo1;

import akka.actor.ActorSystem;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * Created by wangdi on 16-11-30.
 */
@SpringBootApplication
public class Demo1Application {

    @Bean(destroyMethod = "shutdown")
    public ActorSystem getActorSystem() {
        ActorSystem actorSystem = ActorSystem.create("helloAkkaSystem");
        return actorSystem;
    }

    public static void main(String[] args) {
        SpringApplication.run(Demo1Application.class, args);
    }
}