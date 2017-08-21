package org.sprintdragon.opensource.akka.demo2;

/**
 * CountingActor用于接收Count消息进行计数，接收Get消息回复给发送者当前的计数值。CountingService是用于计数的接口，其定义如下：
 * Created by wangdi on 17-8-15.
 */
public interface CountingService {

    /**
     * 计数
     *
     * @param count
     * @return
     */
    int increment(int count);

}