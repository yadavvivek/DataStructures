package com.vivek.practice;

public class PracticeThreadJoin {
	
	public static void main(String args []) {
		System.out.println("Main Thread started running....");
		
		Thread r = new Thread() {
			@Override
			public void run() {
				// TODO Auto-generated method stub
				System.out.println("BG Thread started running....");
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				};
				System.out.println("BG Thread done running....");
			}
		};
		((Thread) r).start();
		try {
			((Thread) r).join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println("Main Thread joined bg thread....");
		
	}

}
