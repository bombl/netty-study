package com.thinkinnetty.oio;/**
 * @Author: wangs
 * @Date: 2018/6/10
 */

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Description:
 * User:wangs
 * Date:2018/6/10
 */
public class TimeServerExecutorPool {

    private ExecutorService executor;

    public TimeServerExecutorPool(int maxPoolSize, int queueSize) {
        executor = new ThreadPoolExecutor(Runtime.getRuntime().availableProcessors(),
                maxPoolSize, 120L, TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(queueSize));
    }

    public void execute(Runnable task) {
        executor.execute(task);
    }
}
