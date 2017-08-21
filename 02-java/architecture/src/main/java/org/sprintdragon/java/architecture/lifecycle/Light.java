package org.sprintdragon.java.architecture.lifecycle;

/**
 * Created by wangdi on 17-6-15.
 */

import lombok.Data;
import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleException;
import org.apache.catalina.LifecycleListener;
import org.apache.catalina.LifecycleState;
import org.apache.catalina.util.LifecycleSupport;

/**
 * 汽车大灯
 */
@Data
public class Light implements Lifecycle {

    private LifecycleSupport lifecycle = new LifecycleSupport(this);

    private String name;

    public Light(String name) {
        this.name = name;
    }

    @Override
    public void addLifecycleListener(LifecycleListener lifecycleListener) {
        lifecycle.addLifecycleListener(lifecycleListener);
    }

    @Override
    public LifecycleListener[] findLifecycleListeners() {
        return lifecycle.findLifecycleListeners();
    }

    @Override
    public void removeLifecycleListener(LifecycleListener lifecycleListener) {

    }

    @Override
    public void init() throws LifecycleException {

    }

    @Override
    public void start() throws LifecycleException {
        lifecycle.fireLifecycleEvent(Lifecycle.BEFORE_START_EVENT, null);
        System.out.println("大灯 " + name + " 开始发光...");
        lifecycle.fireLifecycleEvent(Lifecycle.AFTER_START_EVENT, null);
    }

    @Override
    public void stop() throws LifecycleException {
        lifecycle.fireLifecycleEvent(Lifecycle.BEFORE_STOP_EVENT, null);
        System.out.println("大灯 " + name + " 关闭...");
        lifecycle.fireLifecycleEvent(Lifecycle.AFTER_STOP_EVENT, null);
    }

    @Override
    public void destroy() throws LifecycleException {

    }

    @Override
    public LifecycleState getState() {
        return null;
    }

    @Override
    public String getStateName() {
        return null;
    }
}