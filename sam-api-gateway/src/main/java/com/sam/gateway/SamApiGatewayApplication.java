package com.sam.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//@EnableEurekaClient
@SpringBootApplication
public class SamApiGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamApiGatewayApplication.class, args);
	}

	/*
	 * @Bean public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
	 * return builder.routes()
	 * 
	 * .route("user", r -> r.path("/user").uri("lb://app-services"))
	 * .route("one-user", r -> r.path("/user/{id}").uri("lb://app-services"))
	 * 
	 * 
	 * .route("rewrite-path", r -> r.path("/api/**") .filters(f ->
	 * f.rewritePath("/api/(?<segment>.*)","/${segment}"))
	 * .uri("lb://app-services")) .build(); }
	 */
}
