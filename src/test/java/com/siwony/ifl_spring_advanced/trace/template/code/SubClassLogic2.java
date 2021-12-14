package com.siwony.ifl_spring_advanced.trace.template.code;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SubClassLogic2 extends TimeMeasurementTemplate<Void> {
    @Override
    protected Void call() {
        log.info("비즈니스 로직2 실행");
        return null;
    }
}
