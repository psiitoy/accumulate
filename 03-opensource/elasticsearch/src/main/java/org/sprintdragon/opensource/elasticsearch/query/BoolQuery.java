package org.sprintdragon.opensource.elasticsearch.query;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.sprintdragon.opensource.elasticsearch.common.Tool;

/**
 * Title: BoolQuery
 * Description: BoolQuery   https://www.elastic.co/guide/en/elasticsearch/reference/2.1/query-dsl-bool-query.html
 * Date:  2016/7/12
 */
@Slf4j
public class BoolQuery {

    public static void main(String[] args) {
        testBoolQuery(Tool.INDEX_NAME, Tool.TYPE_NAME, "name", "c1", "gender", "male", "age", "1", "country", "China");
/*        testBoolQuery(Tool.INDEX_NAME, Tool.TYPE_NAME, "name", "c1", "gender", "male","age","2", "country", "China");

        testBoolQuery(Tool.INDEX_NAME, Tool.TYPE_NAME, "name", "a5", "gender", "male","age","1", "country", "American");
        testBoolQuery(Tool.INDEX_NAME, Tool.TYPE_NAME, "name", "a5", "gender", "male","age","1", "country", "China");

        testBoolQuery(Tool.INDEX_NAME, Tool.TYPE_NAME, "gender", "male", "gender", "male","age","0", "country", "China");

        testBoolFilterQuery(Tool.INDEX_NAME, Tool.TYPE_NAME, "gender", "male", "country", "China");*/
    }

    /*  HTTP 接口
        URL:agg_index/agg_type/_search
        TYPE：POST
        BODY:
            {
              "query": {
                "bool": {
                  "must": {
                    "term": {
                      "gender": "male"
                    }
                  },
                  "filter": {
                    "term": {
                      "gender": "male"
                    }
                  },
                  "must_not": {
                    "range": {
                      "age": {
                        "from": 10,
                        "to": 20
                      }
                    }
                  },
                  "should": [
                    {
                      "term": {
                        "height": "50"
                      }
                    },
                    {
                      "term": {
                        "country": "China"
                      }
                    }
                  ],
                  "minimum_should_match": 1,
                  "boost": 1
                }
              }
            }
     */
    private static void testBoolQuery(String indexName, String typeName, String fieldName1, String fieldValue1, String fieldName2, String fieldValue2, String fieldName3, String fieldValue3, String fieldName4, String fieldValue4) {

        QueryBuilder qb = QueryBuilders.boolQuery()
                //.filter(QueryBuilders.termQuery("gender", "male"))
                .must(QueryBuilders.termQuery(fieldName1, fieldValue1))
                .must(QueryBuilders.termQuery(fieldName2, fieldValue2))
                //.mustNot(QueryBuilders.termQuery(fieldName3, fieldValue3))
                .should(QueryBuilders.termQuery(fieldName4, fieldValue4))
                .should(QueryBuilders.boolQuery().filter((QueryBuilders.termQuery(fieldName1, fieldValue1))))
                .should(QueryBuilders.boolQuery().filter((QueryBuilders.termQuery(fieldName2, fieldValue2))))
                .minimumNumberShouldMatch(3);

        SearchRequestBuilder searchRequestBuilder = Tool.CLIENT.prepareSearch(indexName).setTypes(typeName).setQuery(qb);
        log.info(searchRequestBuilder + "");
        SearchResponse sResponse = searchRequestBuilder.get();
        Tool.CLIENT.close();
        log.info(sResponse + "");
    }


    private static void testBoolFilterQuery(String indexName, String typeName, String fieldName1, String fieldValue1, String fieldName2, String fieldValue2) {

        QueryBuilder qb = QueryBuilders.boolQuery()
                .filter(QueryBuilders.termQuery(fieldName1, fieldValue1))
                .filter(QueryBuilders.termQuery(fieldName2, fieldValue2));
        SearchResponse sResponse = Tool.CLIENT.prepareSearch(indexName).setTypes(typeName).setQuery(qb).get();
        log.info(sResponse + "");
    }

}
