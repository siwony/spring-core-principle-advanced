package com.siwony.ifl_spring_advanced.app.v4;

import com.siwony.ifl_spring_advanced.trace.TraceStatus;
import com.siwony.ifl_spring_advanced.trace.log_trace.LogTrace;
import com.siwony.ifl_spring_advanced.trace.template.AbstractTemplate;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderServiceV4 {

    private final OrderRepositoryV4 orderRepository;
    private final LogTrace trace;

    public void orderItem(String itemId) throws InterruptedException {

        AbstractTemplate<Void> template = new AbstractTemplate<Void>(trace) {
            @Override
            protected Void call() throws InterruptedException {
                orderRepository.save(itemId);
                return null;
            }
        };
        template.execute("OrderService.orderItem()");
    }
}
