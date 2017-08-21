package org.sprintdragon.opensource.shardingjdbc.repository;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LskSkuStockMapper {

    void insert(LspSkuStock entity) throws Exception;

    LspSkuStock findById(Long skuId) throws Exception;

}