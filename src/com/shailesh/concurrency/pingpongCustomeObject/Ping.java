package com.shailesh.concurrency.pingpongCustomeObject;

public class Ping implements Runnable{
	
	private  Signal signal;
	
	
	public Ping(Signal signal) {
		this.signal=signal;
	}

	@Override
	public void run() {

		while(true)
		{
					synchronized (signal) {
						while(!"PING".equals(signal.getSignal()))
						{
							try {
								//signal.notifyAll();
								signal.wait();
							} catch (InterruptedException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}
							
						System.out.println(Thread.currentThread().getName()+"::"+signal.getSignal());
						signal.setSignal("PONG");
						signal.notifyAll();
								
			}//synchronized end
			
			
			
		}//while ends
		
	}

}
