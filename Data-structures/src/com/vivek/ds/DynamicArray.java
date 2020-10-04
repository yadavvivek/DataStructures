package com.vivek.ds;

import java.util.Iterator;

/*Main methods are : add() removeAt() and set()*/

@SuppressWarnings("unchecked")
public class DynamicArray <T> implements Iterable<T>{
	
	private T[] arr;
	private int len = 0;
	private int capacity = 0;
	
	public DynamicArray() {
		this(16);
	}
	
	public DynamicArray(int capacity) {
		if(capacity < 0)
			throw new IllegalArgumentException("Size must be greater than 0!");
		
		this.capacity = capacity;
		arr = (T[]) new Object[capacity];
	}
	
	//method 1  O(1)
	public int size() {
		return len;
	}
	
	//method 2   O(1)
	public boolean isEmpty() {
		return size() == 0;
	}
	
	//method 3    O(n)
	public void add(T elem) {
		if(elem == null)
			throw new IllegalArgumentException("Element shouldn't be null!");
	
		if(len >= capacity) {
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
	
	//method 4   O(n)
	public void clear() {
		for(int i = 0; i < len; i++)
			arr[i] = null;
		len = 0;
	}
	
	//method 5    O(n)
	public T removeAt(int index) {
		if(index >= len || index < 0)
			throw new IllegalArgumentException("Invalid index ! "+ index);
		T data = arr[index];
		T[] new_arr = (T[]) new Object[len-1];
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
	
	
	//method 6    O(n)
	public int indexOf(T elem) {
		if(elem == null) throw new IllegalArgumentException("Elment must not be null!");
		
		for(int i = 0; i < len; i++) {
			if(arr[i] == elem)
				return i;
		}
		return -1;
	}
	
	//method 7    O(n)
	public boolean remove(T elem) {
		if(indexOf(elem) != -1) {
			removeAt(indexOf(elem));
			return true;
		}
		return false;
	}

	
	//method 8  O(1)
	public int getCapacity() {
		return capacity;
	}
	
	//method 9    O(n)
	public boolean contains(T elem) {
		return indexOf(elem) != -1;
	}
	
	// O(n)
	public void add(T elem, int index) {
		if(index < 0 || index >= len) throw new IllegalArgumentException();
		
		T[] new_arr = (T[]) new Object[len+1];
		for(int i = 0, j = 0; i < len; i++, j++) {
			if(j == index) {
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
	
	
	// O(1)
	public T set(int index, T elem) {
		if(index < 0 || index >= len || elem == null) throw new IllegalArgumentException("Parameters are not valid!");
		T data = arr[index];
		arr[index] = elem;
		return data;
	}
	
	//method 11
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T> () {
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
	
	//method 12
	@Override
	public String toString( ) {
		if(len == 0) return "[]";
		
		StringBuilder stringB = new StringBuilder("[");
		for(int i = 0; i < len-1; i++) 
			stringB.append(arr[i]+", ");
		 return stringB.append(arr[len-1] + "]").toString();
	}
}
