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
public class Car implements Lifecycle {

    private LifecycleSupport lifecycle = new LifecycleSupport(this);

    private Light leftLight; //左大灯
    private Light rightLight; //右大灯

    private Engine engine; //引擎

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

    public void run() throws Exception {
        start();
        System.out.println("桑塔拉跑起来了...");
    }

    public void shutdown() throws Exception {
        stop();
        System.out.println("桑塔拉停止了...");
    }

    @Override
    public void init() throws LifecycleException {
    }

    @Override
    public void start() throws LifecycleException {
        lifecycle.fireLifecycleEvent(Lifecycle.BEFORE_START_EVENT, null);
        //先初始化其他组件
        if (engine != null && engine instanceof Lifecycle) {
            ((Lifecycle) engine).start();
        }
        if (leftLight != null && leftLight instanceof Lifecycle) {
            ((Lifecycle) leftLight).start();
        }
        if (rightLight != null && rightLight instanceof Lifecycle) {
            ((Lifecycle) rightLight).start();
        }

        System.out.println("桑塔拉正在启动...");
        lifecycle.fireLifecycleEvent(Lifecycle.AFTER_START_EVENT, null);
    }

    @Override
    public void stop() throws LifecycleException {
        //先停止其他组件
        if (engine != null && engine instanceof Lifecycle) {
            ((Lifecycle) engine).stop();
        }
        if (leftLight != null && leftLight instanceof Lifecycle) {
            ((Lifecycle) leftLight).stop();
        }
        if (rightLight != null && rightLight instanceof Lifecycle) {
            ((Lifecycle) rightLight).stop();
        }

        lifecycle.fireLifecycleEvent(Lifecycle.BEFORE_STOP_EVENT, null);
        System.out.println("桑塔拉正在停止...");
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