package com.sam.function;

import java.util.function.Function;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.function.context.FunctionRegistration;
import org.springframework.cloud.function.context.FunctionType;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.GenericApplicationContext;

@SpringBootApplication
public class SamFunctionDemoApplication implements ApplicationContextInitializer<GenericApplicationContext>{

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

	@Override
	public void initialize(GenericApplicationContext ctx) {
		ctx.registerBean("demo", FunctionRegistration.class,
        () -> new FunctionRegistration<>(uppercase())
            .type(FunctionType.from(String.class).to(String.class)));
	}

}
