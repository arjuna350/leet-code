package com.shailesh.concurrency.pingpong2;

public class Ping implements Runnable{
	
	private  StringBuffer signal;
	
	
	public Ping(StringBuffer signal) {
		this.signal=signal;
	}

	@Override
	public void run() {

		while(true)
		{
					synchronized (signal) {
						while(!"PING".equals(signal.toString()))
						{
							try {
								//signal.notifyAll();
								signal.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
							
						System.out.println(Thread.currentThread().getName()+"::"+signal.toString());
						signal.replace(0,2, "PO");
						signal.notifyAll();
								
			}//synchronized end
			
			
			
		}//while ends
		
	}

}
