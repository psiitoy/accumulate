package org.sprintdragon.java.corejava.scjp.jvm.classload.test3;

/**
 * 被动引用的例子之三：
 * 刚刚讲解时也提到，静态常量在编译阶段就会被存入调用类的常量池中，不会引用到定义常量的类，这是一个特例，需要特别记忆，不会触发类的初始化！
 * Created by wangdi on 17-8-17.
 */
//主类、测试类
public class NotInit {
    public static void main(String[] args) {
        System.out.println(ConstClass.HELLOWORLD);
    }
}