package com.vivek.practice;

import java.util.ArrayList;
import java.util.List;

public class Test1PQ {
	
	private PriorityQuePra<Integer> pq;
	
	List<Integer> list = new ArrayList<Integer>();
	
	private Test1PQ() {
		list.add(3);
		list.add(8);
		list.add(1);
		pq = new PriorityQuePra<Integer>(list);
	}
	
	public static void main(String args []) {
		ProtectedTest pt = new ProtectedTest();
		pt.getLaptopDetails();
		
		Test1PQ tp = new Test1PQ();
		tp.add(0);
		tp.add(-1);
		tp.add(-2);
		System.out.println("PQ : "+tp+"      size : "+tp.size()+"   isMinHeap: "+ tp.isMinHeap() != null ? "Ha!" : "Nahi!");
		int r1 = tp.removeAt(5);
		System.out.println("PQ : "+tp+"      size : "+tp.size()+ "      removed : "+r1);
		int r2 = tp.poll();
		System.out.println("PQ : "+tp+"      size : "+tp.size()+ "      removed : "+r2);
		
	}
	
	public String toString() {
		return pq.toString();
	}
	
	private void add(int a) {
		pq.add(a);
	}
	
	private int size() {
		return pq.size();
	}
	
	private int removeAt(int index) {
		return pq.removeAt(index);
	}
	
	private int poll() {
		return pq.poll();
	}
	
	private boolean isMinHeap() {
		return pq.isMinHeap(0);
	}

}
