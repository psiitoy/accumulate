package org.sprintdragon.java.corejava.scjp.jvm.classload.test1;

/**
 * Created by wangdi on 17-8-17.
 */
//子类
public class SubClass extends SuperClass{
    //静态块，子类初始化时会调用
    static{
        System.out.println("子类初始化！");
    }
}