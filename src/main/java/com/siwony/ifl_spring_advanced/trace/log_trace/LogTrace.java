package com.siwony.ifl_spring_advanced.trace.log_trace;

import com.siwony.ifl_spring_advanced.trace.TraceStatus;

public interface LogTrace {

    TraceStatus begin(String message);

    void end(TraceStatus status);

    void exception(TraceStatus traceStatus, Exception e);
}
