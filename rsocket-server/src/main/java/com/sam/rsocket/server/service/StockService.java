package com.sam.rsocket.server.service;

import java.time.Instant;

import org.springframework.stereotype.Service;

import com.sam.rsocket.server.model.StockData;

import reactor.core.publisher.Mono;

@Service
public class StockService {
	
	public Mono<StockData> getSocks(){
		
		return Mono.just(new StockData("Samiran","TCS",3210.2D,Instant.now()));
	}

}
