package com.sam.rsocket.client;

import java.net.URI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import io.rsocket.Payload;
import io.rsocket.RSocket;
import io.rsocket.core.RSocketConnector;
import io.rsocket.transport.netty.client.WebsocketClientTransport;
import io.rsocket.util.DefaultPayload;
import reactor.core.publisher.Flux;

public class TestClient {

	static final Logger logger = LoggerFactory.getLogger(TestClient.class);

	public static void main(String[] args) {

		/*
		 * RSocket source = RSocketConnector.create().reconnect(Retry.backoff(50,
		 * Duration.ofMillis(500))) .connect(TcpClientTransport.create("localhost",
		 * 7000)).block();
		 * 
		 * RSocketRequester requestor = RSocketRequester.wrap(source,
		 * MimeTypeUtils.APPLICATION_JSON, MimeTypeUtils.APPLICATION_JSON,
		 * RSocketStrategies.create());
		 * 
		 * requestor .route("hello") .data("Samiran") .retrieveMono(String.class).log();
		 */

		WebsocketClientTransport ws = WebsocketClientTransport.create(URI.create("ws://localhost:7000/client-status"));
        RSocket clientRSocket = RSocketConnector.connectWith(ws).block();

        try {
            Flux<Payload> s = clientRSocket.requestStream(DefaultPayload.create("peace"));

            s.take(10).doOnNext(p -> System.out.println(p.getDataUtf8())).blockLast();
        } finally {
            clientRSocket.dispose();
        }
	}

}
