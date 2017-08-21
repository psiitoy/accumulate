package org.sprintdragon.java.corejava.scjp.jvm.classload;

/**
 * JVM类加载器分类详解：
 * 1、Bootstrap ClassLoader：启动类加载器，也叫根类加载器，它负责加载Java的核心类库，加载如(%JAVA_HOME%/lib)目录下的rt.jar（包含System、String这样的核心类）这样的核心类库。根类加载器非常特殊，它不是java.lang.ClassLoader的子类，它是JVM自身内部由C/C++实现的，并不是Java实现的。
 * 2、Extension ClassLoader：扩展类加载器，它负责加载扩展目录(%JAVA_HOME%/jre/lib/ext)下的jar包，用户可以把自己开发的类打包成jar包放在这个目录下即可扩展核心类以外的新功能。
 * 3、System ClassLoader\APP ClassLoader：系统类加载器或称为应用程序类加载器，是加载CLASSPATH环境变量所指定的jar包与类路径。一般来说，用户自定义的类就是由APP ClassLoader加载的。
 * <p>
 * 各种类加载器间关系：以组合关系复用父类加载器的父子关系，注意，这里的父子关系并不是以继承关系实现的。
 * Created by wangdi on 17-8-17.
 */
public class GetClassLoaderTest {
    //验证类加载器与类加载器间的父子关系
    public static void main(String[] args) throws Exception {
        //获取系统/应用类加载器
        ClassLoader appClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println("系统/应用类加载器：" + appClassLoader);
        //获取系统/应用类加载器的父类加载器，得到扩展类加载器
        ClassLoader extcClassLoader = appClassLoader.getParent();
        System.out.println("扩展类加载器" + extcClassLoader);
        System.out.println("扩展类加载器的加载路径：" + System.getProperty("java.ext.dirs"));
        //获取扩展类加载器的父加载器，但因根类加载器并不是用Java实现的所以不能获取
        System.out.println("扩展类的父类加载器：" + extcClassLoader.getParent());
    }

}
