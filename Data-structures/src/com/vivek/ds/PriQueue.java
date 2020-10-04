package com.vivek.ds;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class PriQueue<T extends Comparable<T>> {
	
	private int heapSize;
	private int capacity;
	private List<T> heap;
	
	public PriQueue( ) {
		this(1);
	}
	
	public PriQueue(int capacity) {
		heap = new ArrayList<>(capacity);
	}
	
	public PriQueue(T[] elems) {      // y u v
		heapSize = capacity = elems.length;   // 3
		heap = new ArrayList<>(capacity);    // [3]
		for(int i = 0; i < heapSize; i++) {   
			heap.add(elems[i]);    //   y u v
		}
		for(int i = Math.max(0, (heapSize/2 - 1)); i >= 0; i--){  // i = 0
			sink(i);
		}
	}
	
	public PriQueue(Collection<T> elems) {
		this(elems.size());
		for(T elem : elems) {
			add(elem);
		}
	}
	
	public void clear() {
		System.out.println("heapSize: "+heapSize);
		for(int i = heapSize-1; i >= 0; i--) {
			heap.remove(i);
		}
		heapSize = 0;
	}
	
	public int size() {
		return heapSize;
	}
	
	public T peek() {
		return heap.get(0);
	}
	
	public T poll() {
		return removeAt(0);
	}
	
	public boolean contains( T elem) {
		if(elem == null) throw new RuntimeException();
		
		for(T el : heap) {
			if(el.equals(elem)) return true;
		}
		return false;
	}
	
	public void add(T elem) {
		if(elem == null) throw new IllegalArgumentException("Element cannot be null!");
		
		heap.add(elem);
		swim(heapSize);
		heapSize++;
	}
	
	private void sink(int i) {
		while(true) {
			int left = 2*i+1;   // 1 
			int right = 2*i+2;   // 2
			int smallest = left;   // u
			
			if(right < heapSize && less(right, smallest))
				smallest = right;
			
			if(left >= heapSize || less(i, smallest)) break;
			
			swap(i, smallest);
			i = smallest;
		}
	}
	
	@SuppressWarnings("unchecked")
	private boolean less(int i, int j) {
		T data1 = heap.get(i);
		T data2 = heap.get(j);
		
		return data2.compareTo(data1) > 0;
	}
	
	private void swap(int k, int j) {
		T elem_k = heap.get(k);
		T elem_j = heap.get(j);
		
		heap.set(k, elem_j);
		heap.set(j, elem_k);
	}

	private void swim(int k) {
		int parent = (k-1)/2;  // child = 2*parent + 1; parent = (child-1)/2
		
		while(parent >= 0 && less(k, parent)) {
			swap(k, parent);
			k = parent;
			parent = (k-1)/2;
		}
	}
	
	public T removeAt(int index) {
		if(index < 0 || index >= heapSize) throw new IllegalArgumentException();
		
		T data = heap.get(index);
		heapSize--;
		swap(index, heapSize);
		heap.remove(heapSize);
		
		T dataIndex = heap.get(index);  //data after swap means last data
		sink(index);
		
		if(dataIndex.equals(heap.get(index)))
			swim(index);
		return data;
	}
	
	public boolean isMinHeap(int index) {
		while(true) {
			if(index >= heapSize) return true;
		    int left = 2*index + 1;
		    int right = 2*index + 2;
		    
		    if(left < heapSize && less(left, index)) return false;
		    if(right < heapSize && less(right, index)) return false;
		
		    return isMinHeap(left)  && isMinHeap(right);
		}
	}
	
	@Override
	public String toString() {
		return heap.toString();
	}
}
