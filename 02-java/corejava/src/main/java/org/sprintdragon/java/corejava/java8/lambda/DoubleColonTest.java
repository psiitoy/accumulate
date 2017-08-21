package org.sprintdragon.java.corejava.java8.lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 双冒号运算就是Java中的[方法引用],[方法引用]的格式是
 * 类名::方法名
 * Created by wangdi on 17-8-10.
 */
public class DoubleColonTest {

    @Test
    public void convertTest() {
        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected = collected.stream().map(string -> string.toUpperCase()).collect(Collectors.toList());
        System.out.println(collected);
    }

    /**
     * 这种[方法引用]或者说[双冒号运算]对应的参数类型是Function<T,R> T表示传入类型，R表示返回类型。
     * 比如表达式person -> person.getAge(); 传入参数是person，返回值是person.getAge()，
     * 那么方法引用Person::getAge就对应着Function<Person,Integer>类型。
     */
    @Test
    public void convertTest2() {
        List<String> collected = new ArrayList<>();
        collected.add("alpha");
        collected.add("beta");
        collected = collected.stream().map(String::toUpperCase).collect(Collectors.toCollection(ArrayList::new));//注意发生的变化
        System.out.println(collected);
    }

}
