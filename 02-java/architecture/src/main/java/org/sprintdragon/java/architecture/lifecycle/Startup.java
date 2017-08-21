package org.sprintdragon.java.architecture.lifecycle;

import org.apache.catalina.Lifecycle;
import org.apache.catalina.LifecycleEvent;
import org.apache.catalina.LifecycleListener;

/**
 * 参考 http://blog.csdn.net/is_zhoufeng/article/details/49593655
 * Created by wangdi on 17-6-15.
 */
public class Startup {

    public static void main(String[] args) throws Exception {

        //实例化两个灯泡
        Light leftLight = new Light(" 左 ");
        Light rightLight = new Light(" 右 ");

        //实例化一个发动机
        Engine engine = new Engine();

        //实例化一个汽车
        Car car = new Car();
        car.setLeftLight(leftLight);
        car.setRightLight(rightLight);
        car.setEngine(engine);


        //还可以给上面实现了Lifecycle接口的组件添加监听器
        engine.addLifecycleListener(new LifecycleListener() {
            @Override
            public void lifecycleEvent(LifecycleEvent event) {
                //只关心AFTER_START事件
                if (Lifecycle.AFTER_START_EVENT.equals(event.getType())) {
                    System.out.println("监听到发动机启动了，轰轰轰。。。");
                    //这里还可以通过event.getLifecycle()获得engin实例对象，然后做一些业务操作
                } else {
                    //这里可以继续判断其他类型的事件，然后做出处理
                }
            }
        });

        car.addLifecycleListener(new LifecycleListener() {
            @Override
            public void lifecycleEvent(LifecycleEvent event) {
                if (Lifecycle.AFTER_STOP_EVENT.equals(event.getType())) {
                    System.out.println("桑塔拉快停止了,下车吧。。。");
                }
            }
        });

        //启动汽车
        car.run();

        System.out.println("\n\n\n");

        //模拟让桑塔拉跑3秒
        Thread.sleep(3000);

        //关闭汽车
        car.shutdown();

    }

}
