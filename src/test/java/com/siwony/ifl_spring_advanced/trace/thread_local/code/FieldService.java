package com.siwony.ifl_spring_advanced.trace.thread_local.code;

import lombok.extern.slf4j.Slf4j;


@Slf4j
public class FieldService {

    private String nameStore;

    public String logic(String name)  {
        log.info("저장 name={} -> nameStore={}", name, nameStore);
        nameStore = name;
        sleep(1000);
        log.info("조회 nameStore={}", nameStore);
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
