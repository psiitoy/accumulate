package org.sprintdragon.java.corejava.scjp.jvm.classload.test3;

/**
 * Created by wangdi on 17-8-17.
 */
//常量类
public class ConstClass {
    static{
        System.out.println("常量类初始化！");
    }

    public static final String HELLOWORLD = "hello world!";
}