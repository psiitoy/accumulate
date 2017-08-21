package org.sprintdragon.opensource.shardingjdbc.repository;

import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * Created by wangdi on 17-3-9.
 */
@Data
@ToString
public class LspSkuStock {

    private Long id;
    private Long skuId;
    private Long storeId;
    private Long venderId;
    private Integer numStock;
    private String remark;
    private Date created;
    private Date modified;

}
