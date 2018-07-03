package com.shailesh.concurrency.pingpong2;

public class Pong implements Runnable{

	private  StringBuffer signal;
	
	
	public Pong(StringBuffer signal) {
		this.signal=signal;
	}
	
	@Override
	public void run() {

		while(true)
		{
			synchronized (signal) {
				
				while(!"PONG".equals(signal.toString()))
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
				signal.replace(0,2, "PI");
				signal.notifyAll();
				
				
			}//synchronized end
			
			
			
		}//while ends
		
	}

}
