package org.sprintdragon.java.corejava.scjp.jvm.oom;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

/**
 * 注意, 因为 JDK8 已经移除了永久代, 取而代之的是 metaspace, 因此在 JDK8 中, 下面两个例子都不会导致 java.lang.OutOfMemoryError: PermGen space 异常.
 * <p>
 * Created by wangdi on 17-4-20.
 */
public class PermGenOomTest {

    /**
     * 方式一:运行时常量池溢出
     * 在 Java 1.6 以及之前的 HotSpot JVM 版本时, 有永久代的概念, 即 GC 的分代收集机制是扩展至方法区的. 在方法区中, 有一部分内存是用于存储常量池, 因此如果代码中常量过多时, 就会耗尽常量池内存, 进而导致内存溢出.那么如何添加大量的常量到常量池呢? 这时就需要依靠 String.intern() 方法了. String.intern() 方法的作用是: 若此 String 的值在常量池中已存在, 则这个方法返回常量池中对应字符串的引用; 反之将此 String 所包含的值添加到常量池中, 并返回此 String 对象的引用. 在 JDK 1.6 以及之前的版本中, 常量池分配在永久代中, 因此我们可以通过设置参数 “-XX:PermSize” 和 “-XX:MaxPermSize” 来间接限制常量池的大小.
     * 注意, 上面所说的 String.intern() 方法和常量池的内存分布仅仅针对于 JDK 1.6 及之前的版本, 在 JDK 1.7 或以上的版本中, 由于去除了永久代的概念, 因此内存布局稍有不同.
     */
    public static void stringIntern(){
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true) {
            list.add(String.valueOf(i++).intern());
        }
    }

    /**
     *  方式二：调小永久带内存java -XX:PermSize=1M -XX:MaxPermSize=1M
     *  JAVA 1.8同样无效
     */

    /**
     * 方式三：创建大量的Class相关信息
     * 方法区作用是存放 Class 的相关信息, 例如类名, 类访问修饰符, 字段描述, 方法描述等. 因此如果方法区过小, 而加载的类过多, 就会造成方法区的内存溢出.
     *
     */
    /**
     *
     * 在 方法区的内存溢出 内存溢出一节中, 我们提到, JDK8 没有了永久代的概念, 因此那两个例子在 JDK8 下没有实现预期的效果. 那么在 JDK8 下, 是否有类似方法区内存溢出之类的错误呢? 当然有的. 在 JDK8 中, 使用了 MetaSpace 的区域来存放 Class 的相关信息, 因此当 MetaSpace 内存空间不足时, 会抛出 java.lang.OutOfMemoryError: Metaspace 异常.
     * Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
     *
     * //jdk 1.8 VM Args: -XX:MaxMetaspaceSize=10M
     * @param args
     */

    public static void main(String[] args) {
        while (true) {
            Enhancer enhancer = new Enhancer();
            enhancer.setSuperclass(PermGenOomTest.class);
            enhancer.setUseCache(false);
            enhancer.setCallback(new MethodInterceptor() {
                public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                    return methodProxy.invokeSuper(o, objects);
                }
            });

            enhancer.create();
        }
    }



}
