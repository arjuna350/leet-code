package com.shailesh.concurrency.evenodd.lock.condition;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OddEven {

	
	public static void main(String[] a)

	{
		//LinkedBlockingQueue<E>

		Lock lock = new ReentrantLock();

		Condition condition = lock.newCondition();
		
		Thread even = new Thread(new TaskClass1(condition, lock));
		Thread odd = new Thread(new TaskClass2(condition, lock));
		even.start();odd.start();

	/*	Future future1;

		Future future2;

		ExecutorService executorService = Executors.newFixedThreadPool(2);

		future1 = executorService.submit(new TaskClass1(condition, lock));

		future2 = executorService.submit(new TaskClass2(condition, lock));

		executorService.shutdown();*/
		
		

	}
}
