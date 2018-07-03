package com.shailesh.concurrency.pingpongUsingBoolean;

public class Pong implements Runnable{
	
	private volatile boolean signal;
	public boolean isSignal() {
		return signal;
	}

	public void setSignal(boolean signal) {
		this.signal = signal;
	}

	private  Object obj;
	
	public Pong(boolean signal, Object obj) {
		this.signal=signal;
		this.obj=obj;
	}

	@Override
	public void run() {

		while(true)
		{
					synchronized (obj) {
						System.out.println(Thread.currentThread().getName()+"signal value::"+signal);
						while(!signal)
						{
							try {
								System.out.println(Thread.currentThread().getName()+"Going to wait::"+signal);
								obj.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
							
						System.out.println(Thread.currentThread().getName()+"::"+"PONG");
						signal=false;
						System.out.println(Thread.currentThread().getName()+"signal value::"+signal);
						obj.notifyAll();
								
			}//synchronized end
			
			
			
		}//while ends
		
	}

}
