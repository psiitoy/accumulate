package org.sprintdragon.opensource.esjob;

import com.dangdang.ddframe.job.api.ShardingContext;
import com.dangdang.ddframe.job.api.simple.SimpleJob;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * Created by wangdi on 16-12-19.
 */
@Component("taskResumeJob")
@Slf4j
public class TaskResumeJob implements SimpleJob {

    public void execute(ShardingContext shardingContext) {
//        System.out.println("******jobName=" + shardingContext.getJobName() + ",param=" + shardingContext.getJobParameter() + ",shard=" + shardingContext.getShardingParameter() + "," + shardingContext.getShardingItem());
        try {
            long startTime = System.currentTimeMillis();
            log.debug("resumeDbToRedis begin threadName={}", Thread.currentThread().getName());
//            long fetchNum = taskInfoExecuteService.resumeTimeout();
//            log.debug("resumeDbToRedis end threadName{},fetchNum={},cost={}", Thread.currentThread().getName(), fetchNum, System.currentTimeMillis() - startTime);
        } catch (Exception e) {
            log.error("resumeDbToRedis error", e);
        }
    }

}
