package com.sam.rsocket.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.rsocket.RSocketRequester;
import org.springframework.util.MimeTypeUtils;

@Configuration
public class AppConfig {

	/*
	 * @Bean public TcpClientTransport transport() { return
	 * TcpClientTransport.create("localhost", 7000); }
	 * 
	 * @Bean public RSocket rSocket() { return RSocketConnector.create()
	 * .keepAlive(Duration.ofSeconds(2), Duration.ofSeconds(180))
	 * .payloadDecoder(PayloadDecoder.ZERO_COPY) .connect(transport()).block(); }
	 * 
	 * @Bean RSocketRequester rSocketRequester(RSocketStrategies rSocketStrategies)
	 * { return RSocketRequester.wrap(rSocket(), MimeTypeUtils.APPLICATION_JSON,
	 * MimeTypeUtils.APPLICATION_JSON, rSocketStrategies); }
	 */

	/*
	 * @Bean public RSocketRequester rSocketRequester(RSocketRequester.Builder b) {
	 * return b.connectTcp("localhost", 7000).block(); }
	 */

	@Bean
	public RSocketRequester rSocketRequester(RSocketRequester.Builder b) {
		return b.dataMimeType(MimeTypeUtils.APPLICATION_JSON).connectTcp("localhost", 7000).block();
	}

	/*
	 * @Bean //@Qualifier(value = "rSocketRequesterWS") public RSocketRequester
	 * rSocketRequesterWS(RSocketRequester.Builder b) { return
	 * b.dataMimeType(MimeTypeUtils.APPLICATION_JSON)
	 * .connectWebSocket(URI.create("ws://localhost:7000/rsocket")).block(); }
	 */

}
