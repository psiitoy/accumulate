package org.sprintdragon.java.corejava.java8.stream;

import com.google.common.collect.Lists;
import lombok.Data;
import lombok.ToString;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wangdi on 17-8-10.
 */
public class StreamTestSum {

    /**
     * 求和List
     */
    @Test
    public void testSum1() {
        List<Stu> stus = Lists.newArrayList(new Stu("a", 2, 1), new Stu("b", 3, 1), new Stu("c", 4, 0));
        int sum = stus.parallelStream().map(Stu::getAge).reduce(0, (x, y) -> x + y);
        System.out.println(sum);
        //also can 直接转成int调用sum()
        sum = stus.parallelStream().mapToInt(Stu::getAge).sum();
        System.out.println(sum);
    }

    /**
     * 求和Map
     *
     * @throws Exception
     */
    @Test
    public void testSum2() throws Exception {
        List<Stu> stus = Lists.newArrayList(new Stu("a", 2, 1), new Stu("b", 3, 1), new Stu("c", 4, 0));
        Map<Integer, List<Stu>> map = stus.stream().collect(Collectors.groupingBy(Stu::getSex));
        System.out.println(map);
    }

    @Data
    @ToString
    class Stu {
        private String name;
        private Integer age;
        private Integer sex;

        public Stu(String name, Integer age, Integer sex) {
            this.name = name;
            this.age = age;
            this.sex = sex;
        }

    }
}
