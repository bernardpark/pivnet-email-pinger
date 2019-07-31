package com.bpark.pivnetemailpinger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bpark.pivnetemailpinger.service.HttpService;

@Component
public class PivnetemailpingerTask {
	
	Logger logger = LoggerFactory.getLogger( PivnetemailpingerTask.class );

	@Autowired
	HttpService httpService;
	String emailAppUrl;
	List<String> emailList;
	List<String> productList;
	
	@PostConstruct
	public void init() {

	}

	@Scheduled(fixedRate = 86400000)
	public void scheduleTaskWithFixedRate() {
		try {
			for ( String email : emailList ) {
				httpService.addEmail( emailAppUrl, email );
				for ( String product : productList ) {
					httpService.addProduct( emailAppUrl, email, product );
				}
			}
			
			httpService.sendDailyEmails( emailAppUrl );
		}
		catch ( MalformedURLException e ) {
			e.printStackTrace();
		}
		catch ( IOException e ) {
			e.printStackTrace();
		}
	}

}
