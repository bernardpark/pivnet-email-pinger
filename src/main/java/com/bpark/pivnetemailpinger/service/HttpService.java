package com.bpark.pivnetemailpinger.service;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class HttpService {
	
	public void addEmail( String url, String email ) throws MalformedURLException, IOException {
		URL checkUrlObject = new URL( url + "/check-user?" + "email=" + email + "&product=" + email );
		HttpURLConnection connection1 = ( HttpURLConnection ) checkUrlObject.openConnection();
		connection1.setRequestMethod( "GET" );
		connection1.setDoOutput(true);

		if ( connection1.getResponseCode() == 200 ) {
			URL addUrlObject = new URL( url + "/add-user?" + "email=" + email + "&product=" + email );
			HttpURLConnection connection2 = ( HttpURLConnection ) addUrlObject.openConnection();
			connection2.setRequestMethod( "GET" );
			connection2.setDoOutput(true);
		}
		
	}
	
	public void addProduct( String url, String email, String product ) throws MalformedURLException, IOException {
		URL checkUrlObject = new URL( url + "/check-product?" + "email=" + email + "&product=" + product );
		HttpURLConnection connection1 = ( HttpURLConnection ) checkUrlObject.openConnection();
		connection1.setRequestMethod( "GET" );
		connection1.setDoOutput(true);

		if ( connection1.getResponseCode() == 200 ) {
			URL addUrlObject = new URL( url + "/add-product?" + "email=" + email + "&product=" + email );
			HttpURLConnection connection2 = ( HttpURLConnection ) addUrlObject.openConnection();
			connection2.setRequestMethod( "GET" );
			connection2.setDoOutput(true);
		}
	}
	
	public void sendAlertEmails( String url ) throws MalformedURLException, IOException {
		URL checkUrlObject = new URL( url + "/send-new-emails" );
		HttpURLConnection connection1 = ( HttpURLConnection ) checkUrlObject.openConnection();
		connection1.setRequestMethod( "GET" );
		connection1.setDoOutput(true);
		connection1.getResponseCode();
	}
	
	public void sendDailyEmails( String url ) throws MalformedURLException, IOException {
		URL checkUrlObject = new URL( url + "/send-emails" );
		HttpURLConnection connection1 = ( HttpURLConnection ) checkUrlObject.openConnection();
		connection1.setRequestMethod( "GET" );
		connection1.setDoOutput(true);
		connection1.getResponseCode();
	}

}
