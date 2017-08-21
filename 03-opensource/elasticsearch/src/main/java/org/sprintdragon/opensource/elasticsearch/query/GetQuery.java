package org.sprintdragon.opensource.elasticsearch.query;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.cluster.routing.Preference;
import org.sprintdragon.opensource.elasticsearch.common.Tool;

/**
 * Title: IdsQuery
 * Description: IdsQuery
 * Date:  2016/7/12
 */
@Slf4j
public class GetQuery {

    public static void main(String[] args) {
        //testIdsQuery(Tool.INDEX_NAME, Tool.TYPE_NAME);
        testGetQuery("agg_index", Tool.TYPE_NAME, "1");
    }

    /*  HTTP 接口
        URL:agg_index/agg_type/_search
        TYPE：POST
        BODY:
            {
              "query": {
                "ids": {
                  "type": "agg_type",
                  "values": [
                    "1",
                    "4"
                  ]
                }
              }
            }
     */
    private static void testGetQuery(String indexName, String typeName, String docId) {

        //QueryBuilder qb = QueryBuilders.idsQuery("my_type", "type2").addIds("1", "3", "5");
        //get with id
        GetResponse gResponse = Tool.CLIENT.prepareGet(indexName, typeName, docId).setPreference(Preference.PRIMARY_FIRST.type())
                .execute()
                .actionGet();
        log.info("" + JSON.toJSON(gResponse));
    }
}
