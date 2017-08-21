package org.sprintdragon.java.corejava.java8.stream;

import com.google.common.collect.Lists;
import org.junit.Test;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Created by wangdi on 17-8-10.
 */
public class StreamTestGroup {


    /**
     * List -> Map
     *
     * @throws Exception
     */
    @Test
    public void testGroup1() throws Exception {
        List<Stu> stus = Lists.newArrayList(new Stu("a", 2, 1), new Stu("b", 3, 1), new Stu("c", 4, 0));
        Map<Integer, List<Stu>> map = stus.stream().collect(Collectors.groupingBy(Stu::getSex));
        System.out.println(map);
    }

}
