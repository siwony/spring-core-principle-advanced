package com.siwony.ifl_spring_advanced.trace.thread_local.code;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FieldService {

    private String nameStore;

    public String logic(String name)  {
        log.info("์ ์ฅ name={} -> nameStore={}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("์กฐํ nameStore={}", nameStore);
        return  nameStore;
    }

    private void sleep(long time){
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
