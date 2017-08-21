package org.sprintdragon.opensource.jpa.mongo;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by wangdi on 16-8-22.
 */
public interface OrderTraceMongoInfoRepository extends PagingAndSortingRepository<OrderTraceInfoMongoInfo, Long> {
}
