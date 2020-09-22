package com.sam.function;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Log
public class DecisionFunction implements Function<SamMessage,SamMessage> {

    @Override
    public SamMessage apply(SamMessage t) {
        log.info("input data in DecisionFunction :" + t.toString());
        if(t.getAge() < 18) {
            t.setDecision("REJECTED");
        }
        else {
            t.setDecision("APPROVED");
        }
        return t;
    }
    
}
