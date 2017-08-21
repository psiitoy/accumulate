package org.sprintdragon.opensource.akka.demo2;

import org.springframework.stereotype.Service;

/**
 * Created by wangdi on 17-8-15.
 */
@Service("countingService")
public class CountingServiceImpl implements CountingService {

    /*
     * (non-Javadoc)
     *
     * @see com.elong.sentosa.metadata.service.CountingService#increment(int)
     */
    @Override
    public int increment(int count) {
        System.out.println("increase " + count + "by 1.");
        return count + 1;
    }

}