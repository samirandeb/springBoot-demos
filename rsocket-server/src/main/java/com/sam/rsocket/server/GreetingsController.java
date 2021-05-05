package com.sam.rsocket.server;

import java.time.Duration;
import java.time.Instant;

import org.springframework.messaging.handler.annotation.DestinationVariable;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Slf4j
@Controller
public class GreetingsController {

	@MessageMapping("hello")
	public Mono<Void> hello(Greeting p) {
		log.info("received: {} at {}", p, Instant.now());
		return Mono.empty();
	}

	@MessageMapping("greet.{name}")
	public Mono<String> greet(@DestinationVariable String name, @Payload Greeting p) {
		log.info("received: {}, {} at {}", name, p, Instant.now());
		return Mono.just("Hello " + name + ", " + p.getMessage() + " at " + Instant.now());
	}

	@MessageMapping("greet-stream")
	public Flux<String> greetStream(@Payload Greeting p) {
		log.info("received:  {} at {}", p, Instant.now());
		return Flux.interval(Duration.ofSeconds(1))
				.map(i -> "greet-stream#(Hello #" + i + "," + p.getMessage() + ") at " + Instant.now());
	}

	@MessageMapping("greet-channel")
	public Flux<String> greetChannel(@Payload Flux<Greeting> p) {
		log.info("received:  {} at {}", p, Instant.now());
		return p.delayElements(Duration.ofSeconds(1)).map(m -> "greet-channel#(" + m + ") at " + Instant.now());
	}
}

@Data
class Greeting {

	String message;
}
