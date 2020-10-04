package com.vivek.practice;

import java.util.Iterator;

public class DynArrayP1<T> implements Iterable<T> {
	
	private T[] arr;
	private int len = 0;
	private int capacity = 0;
	
	public DynArrayP1(int capacity) {
		if(capacity < 0) throw new IllegalArgumentException("Capacity must not be negative! "+capacity);
		arr = (T[]) new Object[capacity];
		this.capacity = capacity;
	}
	
	public DynArrayP1() {
		this(8);
	}

	//method 1
	public int size() {
		return len;
	}
	
	//method 2
	public boolean isEmpty() {
		return size() == 0;
	}
	
	//method3
	public void add(T elem) {
		if(elem == null) throw new IllegalArgumentException("Element must not be null! "+elem);
		
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
		if(index < 0 || index >= len) throw new ArrayIndexOutOfBoundsException("ArrayIndexOutOfBoundsException!..."+index);
		
		T data = arr[index];
		T[] new_arr = (T[]) new Object[len-1];
		for(int i = 0, j = 0; i < len; i++, j++) {
			if(i == index)
				j--;
			else 
				new_arr[j] = arr[i];
		}
		arr = new_arr;
		len--;
		capacity = len;
		return data;
	}
	
	//method 6 
	public int indexOf(T elem) {
		for(int i = 0; i < len; i++) {
			if(arr[i] == elem) {
				return i;
			}
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
	public int getCapacity() {
		return capacity;
	}
	
	//method 9
	public boolean contains(T elem) {
		return indexOf(elem)!= -1;
	}
	
	//method 10
	public void add(T elem, int index) {
		if(elem == null || index >= len || index < 0) throw new IllegalArgumentException("Element must not be null and index should be propper!");
		
		T[] new_arr = (T[]) new Object[len+1];
		for(int i = 0; i < index; i++) {
			new_arr[i] = arr[i];
		}
		new_arr[index] = elem;
		
		for(int i = index; i < len; i++) {
			new_arr[i+1] = arr[i];
		}
		arr = new_arr;
		len++;
		capacity = len;
	}
	
	//method 11
	public T set(int index, T elem) {
		if(index >= len || index < 0 || elem == null) throw new IllegalArgumentException();
		T data = arr[index];
		arr[index] = elem;
		return data;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		
		return new Iterator<T>(){
			int index = 0;
			@Override
			public boolean hasNext() {
				return index < len;
			}

			@Override
			public T next() {
				return arr[index++];
			}
			
		};
	}
	
	@Override
	public String toString() {
		if(len == 0) return "[]";
		StringBuilder sb = new StringBuilder("[");
		for(int i = 0; i < len-1; i++)
			sb.append(arr[i]+", ");
		return sb.append(arr[len-1]+"]").toString();
	}

}
