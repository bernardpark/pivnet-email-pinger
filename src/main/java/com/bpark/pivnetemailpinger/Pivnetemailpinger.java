package com.bpark.pivnetemailpinger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.bpark.pivnetemailpinger.service.HttpService;


@Configuration
public class Pivnetemailpinger {

	@Bean
	public HttpService httpService() {
		final HttpService httpService = new HttpService();
		return httpService;
	}

}

