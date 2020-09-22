package com.sam.function;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SamFunctionDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SamFunctionDemoApplication.class, args);
	}

	@Bean
	public Function<String,String> uppercase(){
		return value -> value.toUpperCase();
	}

	@Bean
	public Function<String,String> reverse(){
		return value -> new StringBuilder(value).reverse().toString();
	}

}
