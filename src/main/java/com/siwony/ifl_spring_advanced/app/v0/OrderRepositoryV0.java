package com.siwony.ifl_spring_advanced.app.v0;

import org.springframework.stereotype.Repository;

@Repository
public class OrderRepositoryV0 {

    public void save(String itemId) throws InterruptedException {
        //저장 로직
        if(itemId.equals("ex")){
            throw new IllegalStateException("예외 발생");
        }
        Thread.sleep(1000L);
    }
}
