package com.vivek.practice;

import java.util.ArrayList;
import java.util.List;

public class PriorityQuePra<T extends Comparable<T>> {

	private int mHeapSize;
	private List<T> mHeap;
	private int mCapacity;
	
	public PriorityQuePra() {
		mHeap = new ArrayList<>();
	}
	
	public PriorityQuePra(List<T> elems) {
		
		if(elems.isEmpty())
			throw new RuntimeException("Items must not be empty!");
		mHeapSize = mCapacity = elems.size();
		mHeap = new ArrayList<>(mHeapSize);
		
		for(T elem : elems) {
			mHeap.add(elem);
		}
		
		for(int i = Math.max(0, ((mHeapSize/2) -1)); i >= 0 ; i--) {
			System.out.println(" i : "+i);
			sink(i);
		}
	}
	
	public void sink(int k) {
		while(k < mHeapSize && k >= 0) {
			int left = 2*k + 1;
			int right = 2*k + 2;
			
			int smallest = left;
			
			if (right < mHeapSize && !less(left, right)) {
				smallest = right;
			}
			
			if(left >= mHeapSize || less(k, smallest)) return;
			
			swap(k, smallest);
			
			k = smallest;
		}
	}
	
	public T peek() {
		return mHeap.get(0);
	}
	
	public T poll() {
		return removeAt(0);
	}
	
	public T removeAt(int k) {
		if (k >= mHeapSize && k < 0) throw new RuntimeException("Invalid position of elements to be removed!");
		swap(k, --mHeapSize);
		T data = mHeap.get(mHeapSize);
		mHeap.set(mHeapSize, null);
		if(isEmpty() || k == mHeapSize) return data;
		
		T newPlaceData = mHeap.get(k);
		sink(k);
		if(mHeap.get(k).equals(newPlaceData))
			swim(k);
		return data;
	}
	
	public int size() {
		return mHeapSize;
	}
	
	public boolean isEmpty() {
		return mHeapSize == 0;
	}
	
	public void clear() {
		for(int i = 0; i < mHeapSize; i ++) {
			mHeap.set(i, null);
		}
		
		mHeapSize = 0;
	}
	
	public void add(T elem) {
		if(mHeapSize < mCapacity) {
			mHeap.set(mHeapSize, elem);
		} else {
			mHeap.add(elem);
		}
		
		swim(mHeapSize);
		mHeapSize++;
		mCapacity++;
	}
	
	private void swim(int k) {
		int parent = (k-1)/2;
		
		while(parent >= 0 && !less(parent, k)) {
			swap(k, parent);
			k = parent;
			parent = (k-1)/2;
		}
	}
	
	private void swap(int p, int q) {
		T elemP = mHeap.get(p);
		T elemQ = mHeap.get(q);
		
		mHeap.set(p, elemQ);
		mHeap.set(q, elemP);
	}
	
	public boolean less(int p, int q) {
		T elemP = mHeap.get(p);
		T elemQ = mHeap.get(q);
		
		return elemP.compareTo(elemQ) <= 0;
	}
	
	public String toString() {
		return mHeap.toString();
	}
	
	public boolean isMinHeap(int k) {
		
		if(k < 0 || k >= mHeapSize) throw new RuntimeException("Invalid index!");
		
		while(true) {
			if(k >= mHeapSize) return true;
			
			int left = 2*k + 1;
			int right = 2*k +2;
			
			if(left <= mHeapSize && right <= mHeapSize && less(k, left) && less(k, right))
				return isMinHeap(left) && isMinHeap(right);
			else
				return false;
		}
	}
}
