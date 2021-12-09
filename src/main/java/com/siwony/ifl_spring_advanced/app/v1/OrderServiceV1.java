package com.siwony.ifl_spring_advanced.app.v1;

import com.siwony.ifl_spring_advanced.trace.TraceStatus;
import com.siwony.ifl_spring_advanced.trace.hello_trace.HelloTraceV1;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV1 {

    private final OrderRepositoryV1 orderRepository;
    private final HelloTraceV1 trace;

    public void orderItem(String itemId) throws InterruptedException {

        TraceStatus status = null;
        try{
            status = trace.begin("OrderService.orderItem()");
            orderRepository.save(itemId);
            trace.end(status);
        }catch(Exception e){
            trace.exception(status, e);
            throw e;
        }
    }
}
