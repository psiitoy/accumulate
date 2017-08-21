package org.sprintdragon.java.corejava.scjp.jvm.oom;

/**
 * 我们知道, JVM 的运行时数据区中有一个叫做 虚拟机栈 的内存区域, 此区域的作用是: 每个方法在执行时都会创建一个栈帧, 用于存储局部变量表, 操作数栈, 方法出口等信息.
 * 因此我们可以创建一个无限递归的递归调用, 当递归深度过大时, 就会耗尽栈空间, 进而导致了 StackOverflowError 异常.
 * Created by wangdi on 17-4-20.
 */
public class StackOomTest {

    public static void main(String[] args) {
        digui();
    }


    /**
     * java.lang.StackOverflowError
     */
    public static void digui() {
        digui();
    }

}
