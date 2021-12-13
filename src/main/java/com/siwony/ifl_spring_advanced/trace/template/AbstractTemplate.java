package com.siwony.ifl_spring_advanced.trace.template;

import com.siwony.ifl_spring_advanced.trace.TraceStatus;
import com.siwony.ifl_spring_advanced.trace.log_trace.LogTrace;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public abstract class AbstractTemplate<T> {

    private final LogTrace trace;

    public T execute(String message) throws InterruptedException {
        TraceStatus status = null;
        try{
            status = trace.begin(message);

            T result = call();

            trace.end(status);
            return result;
        }catch (Exception e){
            trace.exception(status, e);
            throw e;
        }
    }

    protected abstract T call() throws InterruptedException;
}
