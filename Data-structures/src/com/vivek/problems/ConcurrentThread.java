package com.vivek.problems;

public class ConcurrentThread {
	
	
	private int x;
	
	private void longLoopMethod() {
		for(int i = 0; i < Integer.MAX_VALUE; i ++) {
			x+=i;
			System.out.println("Current Thread : "+ x +"  "+Thread.currentThread());
		}
	}
	
	public static void main (String args []) {
		
		ConcurrentThread ct = new ConcurrentThread();
		
		Runnable r = new Runnable() {
			public void run() {
				ct.longLoopMethod();
			}
			
		};
		
		Thread t = new Thread(r);
		
		t.start();
		ct.longLoopMethod();
		
	}

}
