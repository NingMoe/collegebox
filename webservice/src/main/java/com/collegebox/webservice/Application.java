package com.collegebox.webservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.googlecode.jsonrpc4j.spring.AutoJsonRpcServiceExporter;

@Configuration
@EnableAutoConfiguration
@ComponentScan
public class Application {
	
	@Bean
	public AutoJsonRpcServiceExporter autoJsonRpcServiceExporter() {
		return new AutoJsonRpcServiceExporter();
	}
	
	public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
