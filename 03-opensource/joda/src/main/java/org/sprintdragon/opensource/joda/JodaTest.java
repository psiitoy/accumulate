package org.sprintdragon.opensource.joda;

import org.joda.time.DateTime;

import java.util.Calendar;

/**
 * Created by wangdi on 17-6-12.
 */
public class JodaTest {

    public static void main(String[] args) {
        //1 创建实例
        Calendar calendar = Calendar.getInstance();
        calendar.set(2000, Calendar.JANUARY, 1, 0, 0, 0);
        DateTime dateTime = new DateTime(2000, 1, 1, 0, 0, 0, 0);

        //2. 以 Joda 的方式向某一个瞬间加上 90 天并输出结果
        System.out.println(dateTime.plus(90).toString("E MM/dd/yyyy HH:mm:ss:SSS"));

        //3. 现在假设我希望输出这样一个日期：距离
        // Y2K 45 天之后的某天在下一个月的当前周的最后一天的日期。
        // 坦白地说，我甚至不想使用 Calendar 处理这个问题。使用 JDK 实在太痛苦了，
        // 即使是简单的日期计算，比如上面这个计算。正是多年前的这样一个时刻，我第一次领略到 Joda-Time 的强大。使用 Joda，用于计算的代码如清单 3 所示：
        System.out.println(dateTime.plusDays(45).plusMonths(1).dayOfWeek()
                .withMaximumValue().toString("E MM/dd/yyyy HH:mm:ss.SSS"));

        //清单 4. 将 Joda 计算结果插入到 JDK 对象中
        calendar.setTime(dateTime.toDate());
    }

}
