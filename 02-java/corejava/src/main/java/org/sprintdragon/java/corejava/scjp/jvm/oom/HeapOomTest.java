package org.sprintdragon.java.corejava.scjp.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * Java 堆是用来存储对象实例的, 因此如果我们不断地创建对象, 并且保证 GC Root 和创建的对象之间有可达路径以免对象被垃圾回收, 那么当创建的对象过多时, 会导致 heap 内存不足, 进而引发 OutOfMemoryError 异常.
 * Created by wangdi on 17-4-20.
 */
public class HeapOomTest {

    static List<Integer> list = new ArrayList<>();


    /**
     * java.lang.OutOfMemoryError: Java heap space
     */
    public void oom1() {
        while (true) {
            list.add(Integer.MAX_VALUE);
        }
    }

    public static void main(String[] args) {
        HeapOomTest heapOomTest = new HeapOomTest();
        heapOomTest.oom1();
    }

}
