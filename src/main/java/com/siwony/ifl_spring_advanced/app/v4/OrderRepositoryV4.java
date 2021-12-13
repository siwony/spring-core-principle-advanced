package com.siwony.ifl_spring_advanced.app.v4;

import com.siwony.ifl_spring_advanced.trace.TraceStatus;
import com.siwony.ifl_spring_advanced.trace.log_trace.LogTrace;
import com.siwony.ifl_spring_advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryV4 {

    private final LogTrace trace;

    public void save(String itemId) throws InterruptedException {

        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() throws InterruptedException {
                if(itemId.equals("ex")){
                    throw new IllegalStateException("예외 발생");
                }
                Thread.sleep(1000L);
                return null;
            }
        };
        template.execute("OrderRepository.save()");
    }
}
