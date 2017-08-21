package org.sprintdragon.java.corejava.scjp.jvm.gc;

/**
 * 下面是循环引用的例子，在Hotspot JVM下可以被正常回收，可以证实JVM
 * 采用的不是简单的引用计数法。通过-XX:+PrintGCDetails输出GC日志。
 * Created by wangdi on 17-8-17.
 */
public class ReferenceCount {

    final static int MB = 1024 * 1024;

    byte[] size = new byte[2 * MB];

    Object ref;

    public static void main(String[] args) {
        ReferenceCount objA = new ReferenceCount();
        ReferenceCount objB = new ReferenceCount();
        objA.ref = objB;
        objB.ref = objA;

        objA = null;
        objB = null;

        System.gc();
        System.gc();
    }

}
