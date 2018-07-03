package com.shailesh.concurrency.evenodd.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

//=========== Task1 class prints odd =====

class TaskClass1 implements Runnable

{

	private Condition condition;

	private Lock lock;

	boolean exit = false;

	

	TaskClass1(Condition condition, Lock lock)

	{

		this.condition = condition;

		this.lock = lock;

	}

	@Override

	public void run() {
		
		try

		{
			int i;
			lock.lock();

			for (i = 1; i < 11; i++)

			{

				if (i % 2 == 0)

				{

					condition.signal();

					condition.await();

				}

				if (i % 2 != 0)

				{

					System.out.println(Thread.currentThread().getName() + " == " + i);

				}

			}

		} catch (Exception e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally

		{

			lock.unlock();

		}

	}

}