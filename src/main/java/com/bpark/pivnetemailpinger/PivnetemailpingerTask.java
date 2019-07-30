package com.bpark.pivnetemailpinger;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.bpark.pivnetemailpinger.service.HttpService;

@Component
public class PivnetemailpingerTask {

	@Autowired
	HttpService httpService;
	String emailAppUrl;
	List<String> emailList;
	List<String> productList;
	
	public PivnetemailpingerTask() {
		emailAppUrl = "";
		emailList = new ArrayList<String>();
		productList = new ArrayList<String>();
		
	}

	@Scheduled(fixedRate = 30000)
	public void scheduleTaskWithFixedRate() {
		try {
			for ( String email : emailList ) {
				httpService.addEmail( emailAppUrl, email );
				for ( String product : productList ) {
					httpService.addProduct( emailAppUrl, email, product );
				}
			}
			
			httpService.sendAlertEmails( emailAppUrl );
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
