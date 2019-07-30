package com.bpark.pivnetemailpinger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class PivnetemailpingerApplication {

	public static void main(String[] args) {
		SpringApplication.run( PivnetemailpingerApplication.class, args );
	}

}
