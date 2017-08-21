package org.sprintdragon.java.corejava.scjp.str;

/**
 * Created by wangdi on 17-5-11.
 */
public class TestString {

    public static void main(String[] args) {
        testAdd();
    }

    public static void testAdd1() {
        //a在常量池中了
        String a = "21";
        final String b = "2";
        //c因为b视作常量 所以也入常量池中了
        String c = b + "1";
        //只有使用引号包含文本的方式创建的String对象之间使用“+”连接产生的新对象才会被加入字符串池中
        // a==c true
        System.out.println(a == c);
    }

    public static void testAdd() {
        String a = "21";
        String b = "2";
        //b是变量 c入堆中了
        String c = b + "1";
        // a==c false
        System.out.println(a == c);
    }

}
