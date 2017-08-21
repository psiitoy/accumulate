package org.sprintdragon.java.corejava.java8.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 要求对一个集合里的字符串的小写改为大写
 * Created by wangdi on 17-8-10.
 */
public class StreamTestUpperCase {

    @Test
    public void no1() {
        List<String> list = Arrays.asList("hello", "world", "sky", "moon");
        List<String> list2 = new ArrayList<String>();
        list.forEach(e -> {
            //先放入到list2
            list2.add(e.toUpperCase());
        });
        list2.forEach(e -> System.out.println(e));
    }

    /**
     * 　对于以上代码并没有得到太多的简化，逻辑上与我们之前的代码逻辑差不多，
     * 下面我们采用流的方式来编写
     */
    @Test
    public void use1() {
        List<String> list = Arrays.asList("hello", "world", "sky", "moon");
        list.stream().map(item -> item.toUpperCase())
                .forEach(item -> System.out.println(item));
        System.out.println("=================");
        list.stream().map(String::toUpperCase).forEach(e -> System.out.println(e));
    }

}
