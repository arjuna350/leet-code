package com.shailesh.concurrency.pingpong3;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

public class Ping implements Runnable {

	private Lock signal;
	private Condition condition;
	private AtomicBoolean isPong;

	public Ping(Lock signal, Condition condition, AtomicBoolean isPong) {
		this.signal = signal;
		this.condition = condition;
		this.isPong = isPong;
	}

	@Override
	public void run() {
		try {

			while (true) {

				signal.lock();

				if (isPong.get()) {
					condition.signal();
					condition.await();
				} else {
					System.out.println(Thread.currentThread().getName()+"::"+"PING");
					isPong.set(true);
				}
			} // while ends
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			signal.unlock();
		}
	}

}
