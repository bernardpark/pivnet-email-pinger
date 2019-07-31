package com.bpark.pivnetemailpinger.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpService {
	
	Logger logger = LoggerFactory.getLogger( HttpService.class );

	
	public void addEmail( String url, String email ) throws MalformedURLException, IOException {
		URL checkUrlObject = new URL( url + "/check-user?" + "email=" + email );
		HttpURLConnection connection1 = ( HttpURLConnection ) checkUrlObject.openConnection();
		connection1.setRequestMethod( "GET" );
		connection1.setDoOutput(true);
		int responseCode1 = connection1.getResponseCode();
		logger.info( "METHOD: addEmail( " + email + " ) returned HTTP_STATUS_1" + responseCode1 );

		if ( connection1.getResponseCode() != 200 ) {
			URL addUrlObject = new URL( url + "/add-user?" + "email=" + email );
			HttpURLConnection connection2 = ( HttpURLConnection ) addUrlObject.openConnection();
			connection2.setRequestMethod( "GET" );
			connection2.setDoOutput(true);
			connection2.getResponseCode();
			int responseCode2 = connection2.getResponseCode();
			logger.info( "METHOD: addEmail( " + email + " ) returned HTTP_STATUS_2" + responseCode2 );

		}
	}
	
	public void addProduct( String url, String email, String product ) throws MalformedURLException, IOException {
		URL checkUrlObject = new URL( url + "/check-product?" + "email=" + email + "&product=" + product );
		HttpURLConnection connection1 = ( HttpURLConnection ) checkUrlObject.openConnection();
		connection1.setRequestMethod( "GET" );
		connection1.setDoOutput(true);
		int responseCode1 = connection1.getResponseCode();
		logger.info( "METHOD: addProduct( " + email + ", " + product + " ) returned HTTP_STATUS_1" + responseCode1 );


		if ( responseCode1 != 200 ) {
			URL addUrlObject = new URL( url + "/add-product?" + "email=" + email + "&product=" + product );
			HttpURLConnection connection2 = ( HttpURLConnection ) addUrlObject.openConnection();
			connection2.setRequestMethod( "GET" );
			connection2.setDoOutput(true);
			connection2.getResponseCode();
			int responseCode2 = connection2.getResponseCode();
			logger.info( "METHOD: addProduct( " + email + ", " + product + " ) returned HTTP_STATUS_2" + responseCode2 );

		}
	}
	
	public void sendAlertEmails( String url ) throws MalformedURLException, IOException {
		URL checkUrlObject = new URL( url + "/send-new-emails" );
		HttpURLConnection connection1 = ( HttpURLConnection ) checkUrlObject.openConnection();
		connection1.setRequestMethod( "GET" );
		connection1.setDoOutput(true);
		connection1.getResponseCode();
		int responseCode1 = connection1.getResponseCode();
		logger.info( "METHOD: sendAlertEmails( " + url + " ) returned HTTP_STATUS_1" + responseCode1 );

	}
	
	public void sendDailyEmails( String url ) throws MalformedURLException, IOException {
		URL checkUrlObject = new URL( url + "/send-emails" );
		HttpURLConnection connection1 = ( HttpURLConnection ) checkUrlObject.openConnection();
		connection1.setRequestMethod( "GET" );
		connection1.setDoOutput(true);
		connection1.getResponseCode();
		int responseCode1 = connection1.getResponseCode();
		logger.info( "METHOD: sendDailyEmails( " + url + " ) returned HTTP_STATUS_1" + responseCode1 );
	}

}
