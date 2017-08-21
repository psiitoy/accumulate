package org.sprintdragon.opensource.shardingjdbc.config;//package org.sprintdragon.experiment.shardingjdbc.config;
//
//import com.dangdang.ddframe.rdb.sharding.api.rule.DataSourceRule;
//import com.dangdang.ddframe.rdb.sharding.api.rule.TableRule;
//import com.dangdang.ddframe.rdb.sharding.api.strategy.database.DatabaseShardingStrategy;
//import com.dangdang.ddframe.rdb.sharding.api.strategy.table.TableShardingStrategy;
//import org.sprintdragon.experiment.shardingjdbc.algorithm.SingleKeyModuloDatabaseShardingAlgorithm;
//import org.sprintdragon.experiment.shardingjdbc.algorithm.SingleKeyModuloTableShardingAlgorithm;
//
//import java.util.Arrays;
//
///**
// * Created by wangdi on 17-3-9.
// */
//public class SkuTableRuleFactory {
//
//    public static TableRule createTableRule(DataSourceRule dataSourceRule) {
//        TableRule orderTableRule = TableRule.builder("core_stocknum_pop")
//                .actualTables(Arrays.asList("core_stocknum_pop_0", "core_stocknum_pop_1"))
//                .dataSourceRule(dataSourceRule)
//                .databaseShardingStrategy(new DatabaseShardingStrategy("sku_id", new SingleKeyModuloDatabaseShardingAlgorithm()))
//                .tableShardingStrategy(new TableShardingStrategy("sku_id", new SingleKeyModuloTableShardingAlgorithm()))
//                .build();
//        return orderTableRule;
//    }
//}
