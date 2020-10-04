package com.vivek.ds;

import java.util.Iterator;
import java.util.LinkedList;

public class StackImp<T> implements Iterable<T> {
	
	private LinkedList<T> list = new LinkedList<T>();
	
	public int size() {
		return list.size();
	}
	
	public boolean isEmpty() {
		return list.isEmpty();
	}
	
	public void push(T elem) {
		list.addLast(elem);
	}
	
	public T pop() {
		if(list.isEmpty()) throw new RuntimeException();
		
		return list.removeLast();
	}
	
	public T peek() {
		if(list.isEmpty()) throw new RuntimeException();
		
		return list.peekLast();
	}
	
	@Override
	public String toString() {
		LinkedList<T> newList = new LinkedList<T>();
		for(int i = list.size() - 1; i >= 0; i--)
			newList.add(list.get(i));
		return newList.toString();
	}

	@Override
	public Iterator<T> iterator() {
		return list.iterator();
		
	}
}
