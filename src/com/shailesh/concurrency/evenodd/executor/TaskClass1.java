package com.shailesh.concurrency.evenodd.executor;

import java.util.concurrent.ExecutorService;

import java.util.concurrent.Executors;

import java.util.concurrent.Future;

import java.util.concurrent.locks.Condition;

import java.util.concurrent.locks.Lock;

import java.util.concurrent.locks.ReentrantLock;

//=========== Task1 class prints odd =====

class TaskClass1 implements Runnable

{

	private Condition condition;

	private Lock lock;

	boolean exit = false;

	int i;

	TaskClass1(Condition condition, Lock lock)

	{

		this.condition = condition;

		this.lock = lock;

	}

	@Override

	public void run() {

		try

		{

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