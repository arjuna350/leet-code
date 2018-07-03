package com.shailesh.concurrency.pingpongUsingBoolean;

public class PingPongManager {
	
 volatile static	Boolean signal = true;
	

	public static void main(String[] args) throws InterruptedException {
		//PingPongManager pm= new PingPongManager();
		
		
		//StringBuffer signal = new StringBuffer("PING");
		//boolean signal = true;
		Object obj =new Object();
		
		Ping ping=new Ping(signal,obj);
		Pong pong= new Pong(signal,obj);
		
		Thread pingT = new Thread(ping);
		Thread pongT = new Thread(pong);
		
		System.out.println(Thread.currentThread().getName()+"::compare signal before::"+ (ping.isSignal()==pong.isSignal()));
		pingT.start();
		pongT.start();
		Thread.currentThread().sleep(500);
		System.out.println(Thread.currentThread().getName()+"::compare signal after::"+ (ping.isSignal()==pong.isSignal()));

		
	}

}
