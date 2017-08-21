package org.sprintdragon.opensource.jpa;

import org.junit.Test;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.sprintdragon.opensource.jpa.mongo.OrderTraceInfoMongoInfo;
import org.sprintdragon.opensource.jpa.mongo.OrderTraceMongoInfoRepository;

import javax.annotation.Resource;
import java.util.Iterator;

/**
 * Created by wangdi on 16-8-16.
 */
public class DataMongoTest extends BaseIT {

    @Resource
    OrderTraceMongoInfoRepository repository;

    @Test
    public void testGet() throws Exception {
        Pageable pageable = new PageRequest(1, 10);
        Page<OrderTraceInfoMongoInfo> page = repository.findAll(pageable);
        for (Iterator it = page.iterator(); it.hasNext(); ) {
            System.out.println("##" + it.next());
        }
        pageable = new PageRequest(2, 10);
        page = repository.findAll(pageable);
        System.out.println("##" + page);
    }
}
