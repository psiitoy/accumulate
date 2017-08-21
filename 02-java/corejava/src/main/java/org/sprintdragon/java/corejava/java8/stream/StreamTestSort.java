package org.sprintdragon.java.corejava.java8.stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wangdi on 17-8-10.
 */
public class StreamTestSort {


    /**
     * List -> Map
     *
     * @throws Exception
     */
    @Test
    public void testSort1() throws Exception {
        List<Stu> stus = Lists.newArrayList(new Stu("a", 2, 1), new Stu("b", 3, 1), new Stu("c", 4, 0));
        Map<Integer, List<Stu>> map = stus.stream().collect(Collectors.groupingBy(Stu::getSex));
        List<Stu> nl = Lists.newArrayList();
        map.values().stream().forEach(l -> nl.addAll(l));
        Collections.sort(nl);
        System.out.println(nl);

    }

}
