package com.collegebox.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceExporter;

@SpringBootApplication
@EnableAsync
@EnableScheduling
public class Application {
	
	@Bean
	public AutoJsonRpcServiceExporter autoJsonRpcServiceExporter() {
		return new AutoJsonRpcServiceExporter();
	}
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
