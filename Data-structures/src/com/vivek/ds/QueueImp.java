package com.vivek.ds;

import java.util.Iterator;
import java.util.LinkedList;

public class QueueImp<T> implements Iterable<T> {
	
	private LinkedList<T> list = new LinkedList<T>();

	public QueueImp() {
		
	}
	
	public QueueImp(T elem) {
		offer(elem);
	}
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public T peek() {
		if(isEmpty()) throw new RuntimeException();
		
		return list.peekFirst();
	}
	
	public T poll() {
		if(isEmpty()) throw new RuntimeException();
		
		return list.removeFirst();
	}
	
	public void offer(T elem) {
		list.addLast(elem);
	}
	
	@Override
	public Iterator<T> iterator() {
		return list.iterator();
	}
}
