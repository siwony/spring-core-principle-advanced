package com.siwony.ifl_spring_advanced.trace;

import lombok.Getter;

import java.util.UUID;

public class TraceId {

    private String id;
    private int level;

    public TraceId(){
        this.id = createId();
        this.level = 0;
    }

    private TraceId(String id, int level){
        this.id = id;
        this.level = level;
    }

    private String createId(){
        return UUID.randomUUID().toString().substring(0, 8);
    }

    public TraceId createNextId(){
        return new TraceId(this.id, this.level + 1);
    }

    public TraceId createPreviousId(){
        return new TraceId(this.id, level - 1);
    }

    public boolean isFirstLevel(){
        return this.level == 0;
    }

    public String getId() {
        return this.id;
    }

    public int getLevel() {
        return this.level;
    }

}
