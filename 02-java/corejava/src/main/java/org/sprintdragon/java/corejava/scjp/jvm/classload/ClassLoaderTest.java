package org.sprintdragon.java.corejava.scjp.jvm.classload;

import java.util.List;

/**
 * 下面看一个简单的双亲委派模型代码实例验证：
 * Created by wangdi on 17-8-17.
 */
public class ClassLoaderTest {

    public static void main(String[] args) {
        //输出ClassLoaderText的类加载器名称
        System.out.println("ClassLoaderText类的加载器的名称:" + ClassLoaderTest.class.getClassLoader().getClass().getName());
        System.out.println("System类的加载器的名称:" + System.class.getClassLoader());
        System.out.println("List类的加载器的名称:" + List.class.getClassLoader());

        ClassLoader cl = ClassLoaderTest.class.getClassLoader();
        while (cl != null) {
            System.out.print(cl.getClass().getName() + "->");
            cl = cl.getParent();
        }
        System.out.println(cl);
    }
}
