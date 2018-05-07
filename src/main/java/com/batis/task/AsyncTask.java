package com.batis.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

@Component
public class AsyncTask {

    @Async
    public Future<Boolean> doTask() throws Exception{
        long start= System.currentTimeMillis();
        Thread.sleep(1000);
        long end= System.currentTimeMillis();
        System.out.println("task1耗时:"+ (end - start) + "毫秒");
        return new AsyncResult<>(true);
    }


}
