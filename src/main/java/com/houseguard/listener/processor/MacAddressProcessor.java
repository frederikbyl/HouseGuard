package com.houseguard.listener.processor;

import java.util.ArrayList;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;
import org.joda.time.DateTime;

public class MacAddressProcessor {

	// private ArrayList<String> addressList = new ArrayList<String>();

	public void process(String macAddress, MacAddressType type)  {
		// System.out.println(type.name() +": "+ macAddress);
		// We are checking on probe requests -> only MacAddressType.SOURCE
		System.out.println("INFO " + macAddress);
		// if(type.equals(MacAddressType.SOURCE) &&
		// !addressList.contains(macAddress)) {
		// if( !addressList.contains(macAddress)) {
		// System.out.println("ALERT "+macAddress);
		// ALERTER ALERT
		// SEND OWN PACKET TO GET MORE INFO?????????

		try {
			sendPost(macAddress, new DateTime());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		// addressList.add(macAddress);
		// }

	}

	private void sendPost(String macaddress, DateTime time) throws Exception {
		HttpClient httpClient = HttpClientBuilder.create().build(); // Use this
																	// instead

		HttpPost request = new HttpPost("http://yoururl");
		StringEntity params = new StringEntity("details={\"name\":\"myname\",\"age\":\"20\"} ");
		request.addHeader("content-type", "application/x-www-form-urlencoded");
		request.setEntity(params);
		HttpResponse response = httpClient.execute(request);

		
	}

}
