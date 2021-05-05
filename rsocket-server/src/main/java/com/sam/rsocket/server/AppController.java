package com.sam.rsocket.server;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.stereotype.Controller;

import com.sam.rsocket.server.model.StockData;
import com.sam.rsocket.server.service.StockService;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class AppController {

	@Autowired
	private StockService stockService;

	@MessageMapping("get-stock")
	public Mono<StockData> getStockData(String user) {

		log.info("infut user:" + user);

		return stockService.getSocks();
	}
	
	@MessageMapping("reatime.stockUpdate")
	 public Flux<StockData> getStockUpdates(String status) {
	   log.info("input in getStockUpdates service payload {}", status);
	   return Flux.interval(Duration.ofSeconds(2))
			   .map(index -> new StockData("Samiran","TCS",3210.2D,Instant.now()));
	 }

	@MessageMapping("hi")
	public Mono<String> hello(String user) {

		log.info("input in hello service user:" + user);
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
		LocalDateTime now = LocalDateTime.now();

		return Mono.just("Hello " + user + ", at:" + dtf.format(now));
	}
	
	@MessageMapping("client-status")
	 public Flux<String> statusUpdate(String status) {
	   log.info("Connection {}", status);
	   return Flux.interval(Duration.ofSeconds(5)).map(index -> String.valueOf(Runtime.getRuntime().freeMemory()));
	 }
	
	
	

}
