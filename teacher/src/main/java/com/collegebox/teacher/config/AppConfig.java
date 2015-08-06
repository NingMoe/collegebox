package com.collegebox.teacher.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.collegebox.teacher")
@ImportResource("classpath:spring-security.xml")
public class AppConfig extends WebMvcConfigurerAdapter {
	
	// 配置将 application/hal+json 转为 application/json 解析
	public void configureMessageConverters(
	        List<HttpMessageConverter<?>> messageConverters) {
	    MappingJackson2HttpMessageConverter jsonMessageConverter = new MappingJackson2HttpMessageConverter();
	    jsonMessageConverter.setSupportedMediaTypes(MediaType
	            .parseMediaTypes("application/hal+json, application/json"));
	    messageConverters.add(jsonMessageConverter);
	}

	@Bean
	public RestTemplate restTemplate() {
	    RestTemplate restTemplate = new RestTemplate();
	    // 增加 application/hal+json 类型
	    List<HttpMessageConverter<?>> messageConverters = new ArrayList<HttpMessageConverter<?>>();
	    configureMessageConverters(messageConverters);
	    restTemplate.setMessageConverters(messageConverters);
	    return restTemplate;
	}
	
	@Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

}
