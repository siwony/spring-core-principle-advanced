package com.siwony.ifl_spring_advanced.trace;


import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class TraceStatus {

    private TraceId traceId;
    private Long startTimeMs; // 로그 시작시간
    private String message;
}
