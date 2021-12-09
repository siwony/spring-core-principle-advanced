package com.siwony.ifl_spring_advanced.app.v1;

import com.siwony.ifl_spring_advanced.trace.TraceStatus;
import com.siwony.ifl_spring_advanced.trace.hello_trace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV1 {

    private final HelloTraceV1 trace;

    public void save(String itemId) throws InterruptedException {

        TraceStatus status = null;
        try{
            status = trace.begin("OrderService.save()");
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
