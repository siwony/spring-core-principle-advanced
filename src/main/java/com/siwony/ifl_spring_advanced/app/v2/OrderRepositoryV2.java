package com.siwony.ifl_spring_advanced.app.v2;

import com.siwony.ifl_spring_advanced.trace.TraceId;
import com.siwony.ifl_spring_advanced.trace.TraceStatus;
import com.siwony.ifl_spring_advanced.trace.hello_trace.HelloTraceV1;
import com.siwony.ifl_spring_advanced.trace.hello_trace.HelloTraceV2;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV2 {

    private final HelloTraceV2 trace;

    public void save(TraceId traceId, String itemId) throws InterruptedException {

        TraceStatus status = null;
        try{
            status = trace.beginSync(traceId, "Repository.save()");
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
