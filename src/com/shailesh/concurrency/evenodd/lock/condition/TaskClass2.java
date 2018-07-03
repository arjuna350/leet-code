package com.shailesh.concurrency.evenodd.lock.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class TaskClass2 implements Runnable

{

	private Condition condition;

	private Lock lock;

	boolean exit = false;

	TaskClass2(Condition condition, Lock lock)

	{

		this.condition = condition;

		this.lock = lock;

	}

	@Override

	public void run() {

		int i;

		// TODO Auto-generated method stub

		try

		{

			lock.lock();

			for (i = 2; i < 11; i++)

			{

				if (i % 2 != 0)

				{

					condition.signal();

					condition.await();

				}

				if (i % 2 == 0)

				{

					System.out.println(Thread.currentThread().getName() + " == " + i);

				}

			}

		} catch (InterruptedException e) {

			// TODO Auto-generated catch block

			e.printStackTrace();

		} finally

		{

			lock.unlock();

		}

	}

}