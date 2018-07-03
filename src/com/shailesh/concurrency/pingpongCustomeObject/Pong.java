package com.shailesh.concurrency.pingpongCustomeObject;

public class Pong implements Runnable{

	private  Signal signal;
	
	
	public Pong(Signal signal) {
		this.signal=signal;
	}
	
	@Override
	public void run() {

		while(true)
		{
			synchronized (signal) {
				
				while(!"PONG".equals(signal.getSignal()))
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
				signal.setSignal("PING");
				signal.notifyAll();
				
				
			}//synchronized end
			
			
			
		}//while ends
		
	}

}
