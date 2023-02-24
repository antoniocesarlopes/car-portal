package br.com.carportal.config;

import java.time.Duration;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
	
	@Value("${api.connect-timeout}")
	private Long connectTimeout;
	
	@Value("${api.read-timeout}")
	private Long readTimeout;

	@Bean
	RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder
				.setConnectTimeout(Duration.ofMillis(connectTimeout)) 
				.setReadTimeout(Duration.ofMillis(readTimeout))
				.build();
	}

}
