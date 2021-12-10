package com.siwony.ifl_spring_advanced.config;

import com.siwony.ifl_spring_advanced.trace.log_trace.LogTrace;
import com.siwony.ifl_spring_advanced.trace.log_trace.ThreadLocalLogTrace;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LogTraceConfig {

    @Bean
    public LogTrace logTrace(){
        return new ThreadLocalLogTrace();
    }

}
