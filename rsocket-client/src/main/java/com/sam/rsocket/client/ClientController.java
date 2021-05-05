package com.sam.rsocket.client;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.sam.rsocket.client.model.StockData;

import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@RestController
public class ClientController {

	@Autowired
	private RSocketRequester requestor;

	@GetMapping("/stock/{user}")
	public Mono<StockData> getStocks(@PathVariable String user) {

		return requestor
				.route("get-stock")
				.data(user)
				.retrieveMono(StockData.class);

	}
	
	@GetMapping(value="/stocks/{user}",produces = MediaType.TEXT_EVENT_STREAM_VALUE )
	public Flux<StockData> getAllStocks(@PathVariable String user) {

		return requestor
				.route("reatime.stockUpdate")
				.data(user)
				.retrieveFlux(StockData.class)
				.take(5);

	}
	
	@GetMapping("/hi/{user}")
	public Mono<String> hello(@PathVariable String user) {

		log.info("input in service hello {}",user);
		
		
		return requestor
				.route("hi")
				.data(user)
				.retrieveMono(String.class);

	}
	
	@GetMapping("status/{status}")
	Flux<String> getStatus(@PathVariable String status) {
		return this.requestor
				.route("client-status")
				.data(status)
				.retrieveFlux(String.class).take(5);
	}

}
