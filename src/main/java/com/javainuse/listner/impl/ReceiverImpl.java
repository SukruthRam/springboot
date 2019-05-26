package com.javainuse.listner.impl;

import org.springframework.stereotype.Component;

import com.javainuse.listner.Receiver;

@Component
public class ReceiverImpl implements Receiver {
	
	@Override
	public void onMessage(String message)
	{
		System.out.println("Incomming Message");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Message Recieved" +message);
		
	}

}
