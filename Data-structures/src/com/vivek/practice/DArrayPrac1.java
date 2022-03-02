package com.vivek.practice;

import java.util.Iterator;

@SuppressWarnings("unchecked")
public class DArrayPrac1<T> implements Iterable<T>{

	private T[] mArr;
	private int mCapacity;
	private int mLen;
	
	public DArrayPrac1() {
		this(16);
	}
	
	public DArrayPrac1(int capacity) {
		if(capacity < 0) throw new IllegalArgumentException();
		
		mCapacity = capacity;
		
		mArr = (T[]) new Object[capacity];
	}
	
	public int size() {
		return mLen;
	}
	
	public boolean isEmpty() {
		return size() == 0;
	}
	
	public void add(T elem) {
		if(mLen == mCapacity) {
			if(mCapacity == 0) mCapacity = 1;
			else mCapacity *= 2;
			T[] new_arr = (T[]) new Object[mCapacity];
			for(int i = 0; i < mLen; i++) 
				new_arr[i] = mArr[i];
			mArr = new_arr;
		}
		mArr[mLen++] = elem;
	}
	
	public T removeAt(int rm_index) {
		if(rm_index < 0 && rm_index >= mLen) throw new IllegalArgumentException();
		
		T data = mArr[rm_index];
		T[]	new_arr = (T[]) new Object[mLen - 1];
		
		for(int i = 0, j = 0; i < mLen; i++, j++) {
			if(i == rm_index) j--;
			else new_arr[j] = mArr[i];
		}
		mCapacity = --mLen;
		mArr = new_arr;
		return data;
	}
	
	
	public boolean remove(Object obj) {
		for(int i = 0; i < mLen; i++) {
			if(mArr[i].equals(obj)) {
				removeAt(i);
				return true;
			}
		}
		
		return false;
	}
	
	public int indexOf(Object obj) {
		for(int i = 0; i < mLen; i++) {
			if(mArr[i].equals(obj)) return i;
		}
		
		return -1;
	}
	
	public boolean contains(Object obj) {
		return indexOf(obj) != -1;
	}
	
	
	
	@Override
	public Iterator<T> iterator() {
		return new Iterator<T>() {
			int index = 0;

			@Override
			public boolean hasNext() {
				return index < mLen;
			}

			@Override
			public T next() {
				return mArr[index++];
			}
			
		};
	}
	
	@Override
	public String toString() {
		if(mLen <= 0) return "[]";
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		for(int i = 0; i < mLen-1; i++) {
			sb.append(mArr[i]+", ");
		}
		sb.append(mArr[mLen-1]+"]");
		return sb.toString();
	}

}
