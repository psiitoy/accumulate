package org.sprintdragon.opensource.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangdi on 16-9-14.
 */
public class FeightTest {

    private static LoadingCache<String, String> cache;

    //    static {
//
//        cache = CacheBuilder.newBuilder()
//                .concurrencyLevel(20)
//                //缓存项在给定时间内没有被写访问，则回收
//                .expireAfterWrite(8, TimeUnit.SECONDS)
//                //定时刷新
//                .refreshAfterWrite(8, TimeUnit.SECONDS)
//                //软引用,内存不足时  自动回收
//                //.softValues()
//                .initialCapacity(20)
//                .maximumSize(200)
//                .build(
//                        new CacheLoader<String, String>() {
//
//                            @Override
//                            public String load(String key) {
//                                //穿透后隔几秒失效 配合 expireAfterWrite
//                                System.out.println("## 穿透 补充数据 fix cache key=" + key);
//                                return "ttt:" + key;
//                            }
//                        }
//                );
//    }
    static {
        cache = CacheBuilder.newBuilder()
                .concurrencyLevel(20).expireAfterWrite(8, TimeUnit.SECONDS)
                //设置缓存容器的初始容量为10
                .initialCapacity(10)
                //设置缓存最大容量为100，超过100之后就会按照LRU最近虽少使用算法来移除缓存项
                .maximumSize(100)
                //build方法中可以指定CacheLoader，在缓存不存在时通过CacheLoader的实现自动加载缓存
                .build(
                        new CacheLoader<String, String>() {

                            @Override
                            public String load(String key) {
                                //穿透后隔几秒失效 配合 expireAfterWrite
                                System.out.println("## 穿透 补充数据 fix cache key=" + key);
                                return "ttt:" + key;
                            }

                        }
                );

    }

    public static void main(String[] args) {
        int executors = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(executors);
        for (int i = 0; i < executors; i++) {
            executorService.submit(new Runnable() {
                public void run() {
                    try {
                        while (true) {
                            cache.get("22");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            });
        }

    }
}
