package com.vivek.practice;

import com.vivek.ds.IndexedPriorityQueue;

public class IPQTest {
	
	public static void main(String args []) {
		IndexedPriorityQueue<String> ipq = new IndexedPriorityQueue<String>(2, 5);
		
		ipq.insert(0, "Z");
		ipq.insert(4, "B");
		ipq.insert(1, "A");
		ipq.insert(3, "C");
		
		int[] pm = ipq.getPm();
		int[] im = ipq.getIm();
		System.out.println("Poll() : "+ipq.poll());
//		System.out.println("delete() : "+ipq.delete(0));
		Object[] values = ipq.getValues();
		int size = ipq.size();
		
		System.out.print("pm: ");
		
		for(int i = 0; i < 5; i++) {
			System.out.print(pm[i]+", ");
		}
		
		System.out.println();
		System.out.println();
		
		System.out.print("im: ");
		for(int i = 0; i < 5; i++) {
			System.out.print(im[i]+", ");
		}
		System.out.println();
		System.out.println();
		System.out.print("val: ");
		for(int i = 0; i < 5; i++) {
			System.out.print(values[i]+", ");
		}	
	}

}
