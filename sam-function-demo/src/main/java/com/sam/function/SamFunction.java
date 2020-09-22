package com.sam.function;

import java.util.function.Function;

import org.springframework.stereotype.Component;

import lombok.extern.java.Log;

@Component
@Log
public class SamFunction implements Function<SamMessage, SamMessage> {

    @Override
    public SamMessage apply(SamMessage t) {

        log.info("input data" + t.toString());
        t.setAdsress("Modified Address");
        t.setDecision("INGESTED");
        return t;
    }

}
