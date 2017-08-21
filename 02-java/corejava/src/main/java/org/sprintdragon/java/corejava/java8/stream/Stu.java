package org.sprintdragon.java.corejava.java8.stream;

import lombok.Data;
import lombok.ToString;

/**
 * Created by wangdi on 17-8-10.
 */
@Data
@ToString
public class Stu implements Comparable<Stu> {
    private String name;
    private Integer age;
    private Integer sex;

    public Stu(String name, Integer age, Integer sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    @Override
    public int compareTo(Stu o) {
        return o.getSex() > sex ? 1 : o.getAge() > age ? 1 : 0;
    }
}