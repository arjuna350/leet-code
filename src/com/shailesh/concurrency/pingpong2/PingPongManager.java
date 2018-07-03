package com.shailesh.concurrency.pingpong2;

public class PingPongManager {
	
	
	

	public static void main(String[] args) {
		//PingPongManager pm= new PingPongManager();
		
		
		StringBuffer signal = new StringBuffer("PING");
		
		

		Thread ping = new Thread(new Ping(signal));
		Thread pong = new Thread(new Pong(signal));
		
		ping.start();
		pong.start();
		
	}

}
