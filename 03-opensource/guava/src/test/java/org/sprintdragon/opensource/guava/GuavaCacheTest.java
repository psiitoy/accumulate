package org.sprintdragon.opensource.guava;

import com.google.common.cache.*;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangdi on 16-9-14.
 */
public class GuavaCacheTest {

    private static LoadingCache<Long, String> cache;

//    static {
//        cache = CacheBuilder.newBuilder().concurrencyLevel(20).expireAfterAccess(8, TimeUnit.SECONDS).refreshAfterWrite(20, TimeUnit.SECONDS).initialCapacity(10).maximumSize(200).removalListener(new RemovalListener<Long, String>() {
//            public void onRemoval(RemovalNotification<Long, String> removalNotification) {
//                System.out.println(removalNotification.getKey() + " was removed,cause is " + removalNotification.getCause());
//            }
//        }).build(new CacheLoader<Long, String>() {
//            @Override
//            public String load(Long aLong) throws Exception {
//                //穿透后隔几秒失效 配合 expireAfterWrite
//                System.out.println("## 穿透 补充数据 fix cache key=" + aLong);
//                return "ttt:" + aLong;
//            }
//
//            @Override
//            public ListenableFuture<String> reload(Long key, String oldValue) throws Exception {
////                隔一段时间刷新 永久不失效 配合refreshAfterWrite
////                return Futures.immediateCheckedFuture(oldValue);
//                return super.reload(key, oldValue);
//            }
//        });
//    }

    static {
        cache = CacheBuilder.newBuilder().concurrencyLevel(20).expireAfterWrite(8, TimeUnit.SECONDS).initialCapacity(10).maximumSize(200).removalListener(new RemovalListener<Long, String>() {
            public void onRemoval(RemovalNotification<Long, String> removalNotification) {
                System.out.println(removalNotification.getKey() + " was removed,cause is " + removalNotification.getCause());
            }
        }).build(new CacheLoader<Long, String>() {
            @Override
            public String load(Long aLong) throws Exception {
                //穿透后隔几秒失效 配合 expireAfterWrite
                System.out.println("## 穿透 补充数据 fix cache key=" + aLong);
                return "ttt:" + aLong;
            }

            @Override
            public ListenableFuture<String> reload(Long key, String oldValue) throws Exception {
//                隔一段时间刷新 永久不失效 配合refreshAfterWrite
//                return Futures.immediateCheckedFuture(oldValue);
                return super.reload(key, oldValue);
            }
        });
    }

    public static void main(String[] args) {
        int executors = 20;
        ExecutorService executorService = Executors.newFixedThreadPool(executors);
        for (int i = 0; i < executors; i++) {

        }
        while (true) {
            try {
                executorService.submit(new Runnable() {
                    public void run() {
                        try {
                            cache.get(22l);
                        } catch (ExecutionException e) {
                            e.printStackTrace();
                        }
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

}
