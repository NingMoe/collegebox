package com.collegebox.webservice.config;

import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.ui.velocity.VelocityEngineFactoryBean;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

@Configuration
@EnableConfigurationProperties(ElasticSearchProperties.class)
public class CollegeBoxConfig {
	
	@Autowired
	private ElasticSearchProperties elasticSearchProperties;
	
	@SuppressWarnings("resource")
	@Bean(destroyMethod = "close")
	public Client client() {
		Settings settings = ImmutableSettings.settingsBuilder()  
                .put("client.transport.sniff", true)  
                .put("client", true)  
                .put("data",false)  
                .put("clusterName","elasticsearch")  
                .build();
		
		return new TransportClient(settings)
		        .addTransportAddress(new InetSocketTransportAddress(
		        		elasticSearchProperties.getHost(), 
		        		elasticSearchProperties.getPort()));
	}
	
	@Bean
	public VelocityEngineFactoryBean velocityEngine() {
		VelocityEngineFactoryBean velocityEngine = new VelocityEngineFactoryBean();
		velocityEngine.setResourceLoaderPath("/template");
		Map<String, Object> velocityProperties = new HashMap<String, Object>();
		velocityProperties.put("output.encoding", "UTF-8");
		velocityProperties.put("input.encoding", "UTF-8");
		velocityEngine.setVelocityPropertiesMap(velocityProperties);
		return velocityEngine;
	}
	
	@Bean
	public VelocityViewResolver velocityViewResolver() {
		VelocityViewResolver velocityViewResolver = new VelocityViewResolver();
		velocityViewResolver.setContentType("text/html;charset=UTF-8");
		return velocityViewResolver;
	}

}
