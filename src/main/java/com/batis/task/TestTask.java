package com.batis.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class TestTask {
    private static final SimpleDateFormat dataFormat= new SimpleDateFormat("HH:mm:ss");
    //TODO 表达式生成网址  cron.qqe2.com
//    @Scheduled(fixedRate = 3000)
    @Scheduled(cron = "1-16 * * * * ?  ")
    public void reportCurrentTime(){
        System.out.println(dataFormat.format(new Date()));
    }
}
