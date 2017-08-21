package org.sprintdragon.opensource.shardingjdbc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by wangdi on 16-11-30.
 */
@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ImportResource({"classpath:/META-INF.spring/spring-config.xml"})
public class ManagerDispatchApplication {
    public static void main(String[] args) {
        SpringApplication.run(ManagerDispatchApplication.class, args);
    }
}