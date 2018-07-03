package com.shailesh.concurrency.pingpong3;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class PingPongManager {
	
	
	

	public static void main(String[] args) {
		
		
		
		Lock signal = new ReentrantLock();
		Condition condition	 = signal.newCondition();
		AtomicBoolean  isPong = new AtomicBoolean();
		
		Thread ping = new Thread(new Ping(signal,condition,isPong));
		Thread pong = new Thread(new Pong(signal,condition,isPong));
		
		ping.start();
		pong.start();
		
	}

}
