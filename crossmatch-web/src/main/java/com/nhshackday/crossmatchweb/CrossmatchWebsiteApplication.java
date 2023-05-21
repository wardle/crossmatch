package com.nhshackday.crossmatchweb;

import com.eldrix.hermes.client.Hermes;
import com.eldrix.hermes.sct.IResult;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class CrossmatchWebsiteApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrossmatchWebsiteApplication.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}
}
