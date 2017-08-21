package org.sprintdragon.opensource.shardingjdbc;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.sprintdragon.opensource.shardingjdbc.repository.LskSkuStockMapper;
import org.sprintdragon.opensource.shardingjdbc.repository.LspSkuStock;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Created by wangdi on 17-3-9.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = ManagerDispatchApplication.class)
public class Test1 {

    @Autowired
    LskSkuStockMapper lskSkuStockMapper;

    @Test
    public void testInsert() throws Exception {
        LspSkuStock skuStock = new LspSkuStock();
        skuStock.setSkuId(System.currentTimeMillis());
        skuStock.setRemark("test1");
        skuStock.setStoreId(22l);
        skuStock.setNumStock(33);
        skuStock.setVenderId(1002l);
        lskSkuStockMapper.insert(skuStock);
    }

    @Autowired
    DataSource shardingDataSource;

    @Test
    public void testSelect() throws Exception {
        String sql = "SELECT * FROM core_stocknum_pop where SKU_ID=?";
        try (
                Connection conn = shardingDataSource.getConnection();
                PreparedStatement preparedStatement = conn.prepareStatement(sql)) {
            preparedStatement.setLong(1, 10);
            try (ResultSet rs = preparedStatement.executeQuery()) {
                while (rs.next()) {
                    System.out.println("##" + rs.getObject(1));
                    System.out.println("##" + rs.getObject(2));
                    System.out.println("##" + rs.getObject(3));
                }
            }
        }
    }

    @Resource
    JdbcTemplate jdbcTemplate;

    @Test
    public void testInsertTs() throws Exception {
        String sql = "INSERT INTO core_stocknum_pop         (SKU_ID,STORE_ID,VENDER_ID,NUM_STOCK,REMARK,CREATED,MODIFIED)         VALUES         (?,?,?,?,?,now(),now())";
        jdbcTemplate.update(sql, 100l, 102l, 2000l, 22l, "test1");
    }
}
