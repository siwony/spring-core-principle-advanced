package com.siwony.ifl_spring_advanced.app.v3;

import com.siwony.ifl_spring_advanced.trace.TraceStatus;
import com.siwony.ifl_spring_advanced.trace.log_trace.LogTrace;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV3 {

    private final LogTrace trace;

    public void save(String itemId) throws InterruptedException {

        TraceStatus status = null;
        try{
            status = trace.begin("Repository.save()");
            //저장 로직
            if(itemId.equals("ex")){
                throw new IllegalStateException("예외 발생");
            }
            Thread.sleep(1000L);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status, e);
            throw e;
        }

    }
}
