package com.funo.footstone.bkApiGateway;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@EnableCircuitBreaker
@RestController
public class BkApiGatewayApplication {
	protected static final Logger logger = LoggerFactory.getLogger(BkApiGatewayApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(BkApiGatewayApplication.class, args);
	}

	@Bean
	public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
		return builder.routes()
				.route(r -> r.path("/baidu").uri("http://baidu.com:80/"))
//				.route("websocket_route", r -> r.path("/apitopic1/**").uri("ws://127.0.0.1:6605"))
//				.route(r -> r.path("/userapi3/**").filters(f -> f.addResponseHeader("X-AnotherHeader", "testapi3"))
//						.uri("lb://user-service/"))
				.route(r -> r.path("/testlb2bkConfigServer/**")
						.uri("lb://BKCONFIGSERVER/"))
				.build();
	}

	/*
	 * http://localhost:8007/home
	 * http://localhost:8001/testProducer/testProducerHome2
	 */
	@RequestMapping("/home")
	public String home() {
		return "BkApiGatewayHome, Hello world";
	}
}
