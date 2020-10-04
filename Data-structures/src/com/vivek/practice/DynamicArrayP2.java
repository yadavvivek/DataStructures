package com.vivek.practice;

import java.util.Iterator;

public class DynamicArrayP2<T> implements Iterable<T> {

	private T[] arr;
	private int len;
	private int capacity;
	
	public DynamicArrayP2() {
		
	}
	
	public DynamicArrayP2(int capacity) {
		if(capacity < 0) throw new IllegalArgumentException();
		
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}
	
	//method 1
	public int size() {
		return len;
	}
	
	//method 2
	public boolean isEmpty() {
		return size() == 0;
	}
	
	//method 3
	public void add(T elem) {
		if(elem == null) throw new IllegalArgumentException();
		
		if(len+1 >= capacity) {
			if(capacity == 0)
				capacity = 1;
			else 
				capacity *= 2;
			
			T[] new_arr = (T[]) new Object[capacity];
			for(int i = 0; i < len; i++) {
				new_arr[i] = arr[i];
			}
			
			arr = new_arr;
		}	
		arr[len++] = elem;
	}

	//method 4
	public void clear() {
		for(int i = 0; i < len; i++)
			arr[i] = null;
		len = 0;
	}
	
	//method 5 
	public T removeAt(int index) {
		if(index < 0 || index >= len) throw new IllegalArgumentException();
		
		T data = arr[index];
		T[] new_arr = (T[]) new Object[len - 1];
		for(int i = 0, j = 0; i < len; i++, j++) {
			if(i == index) j--;
			else
				new_arr[j] = arr[i];
		}
		arr = new_arr;
		len--;
		capacity = len;
		return data;
	}
	
	// method 6
	public int indexOf(T elem) {
		if(elem == null) throw new IllegalArgumentException();
		for(int i = 0; i < len; i++) {
			if(arr[i] == elem) return i;
		}
		return -1;
	}
	
	//method 7
	public boolean remove(T elem) {
		if(indexOf(elem) != -1) {
			removeAt(indexOf(elem));
			return true;
		}
		return false;
	}
	
	//method 8
	public boolean contains(T elem) {
		return indexOf(elem) != -1;
	}
	
	//method 9
	public void add(T elem, int index) {
		if(index < 0 || index >= len || elem == null) throw new IllegalArgumentException();
		
		T[] new_arr = (T[]) new Object[len+1];
		for(int i = 0, j = 0; i < len; i++) {
			if(i == index) {
				new_arr[j] = elem;
				i--;
			} else {
				new_arr[j] = arr[i];
			}
		}
		arr = new_arr;
		len++;
		capacity = len;
	}
	
	//method 10
	public T set(T elem, int index) {
		if(index < 0 || index >= len) throw new IllegalArgumentException();
		
		T data = arr[index];
		arr[index] = elem;
		return data;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}	
}
