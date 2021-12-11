package com.siwony.ifl_spring_advanced.trace;

import com.siwony.ifl_spring_advanced.trace.thread_local.code.FieldService;
import com.siwony.ifl_spring_advanced.trace.thread_local.code.ThreadLocalService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FieldServiceTest {

    private final ThreadLocalService service = new ThreadLocalService();

    @Test
    void field(){
        log.info("main start");
        Runnable userA = () -> {
            service.logic("userA");
            service.removeValueInThreadLocal();
            service.lockUpValue();
        };

        Runnable userB = () -> {
            service.logic("userB");
            service.removeValueInThreadLocal();
            service.lockUpValue();
        };

        Thread threadA = new Thread(userA);
        threadA.setName("thread-A");

        Thread threadB = new Thread(userB);
        threadB.setName("thread-B");

        threadA.start();
        threadB.start();

        sleep(3000); //
        log.info("main exit");
    }

    private void sleep(long time) {
        try {
            Thread.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
