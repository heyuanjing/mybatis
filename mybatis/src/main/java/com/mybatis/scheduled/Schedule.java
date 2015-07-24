package com.mybatis.scheduled;

import java.util.Date;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Schedule {

    //@Scheduled(cron="0/10 * * * * *")
    public void test(){
        System.out.println(new Date());
    }
}
