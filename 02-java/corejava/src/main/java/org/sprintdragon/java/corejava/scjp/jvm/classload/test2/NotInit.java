package org.sprintdragon.java.corejava.scjp.jvm.classload.test2;

/**
 * 被动引用的例子之二：
 * 通过数组来引用类，不会触发类的初始化，因为是数组new，而类没有被new，所以没有触发任何“主动引用”条款，属于“被动引用”。代码如下：
 * Created by wangdi on 17-8-17.
 */
//主类、测试类
public class NotInit {
    public static void main(String[] args) {
        SuperClass[] test = new SuperClass[10];
        System.out.println(test);
    }
}