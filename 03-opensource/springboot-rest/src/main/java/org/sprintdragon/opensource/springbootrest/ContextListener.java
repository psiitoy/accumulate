package org.sprintdragon.opensource.springbootrest;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Created by wangdi on 17-6-15.
 */
@WebListener
public class ContextListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent event) {
        System.out.println("application started!!!!!!!!!!!");
    }

    @Override
    public void contextDestroyed(ServletContextEvent event) {
        System.out.println("application stopped!!!!!!!!!");
    }
}