package com.vivek.ds;

public class IndexedPriorityQueue<T extends Comparable<T>> {

	/* current size of the queue */
	private int sz;

	/* it stores values on index of ki */
	private Object values[];

	/* Gives the position of ki in heap */
	private int pm[];

	/* Gives a key at a position */
	private int im[];

	/* Stores the child node of a node: first child node */
	private int child[];

	/* Stores the parent node of a node */
	private int parent[];

	/* Degree of the tree : means how many child it is having */
	private int D = 2;

	/* Max num of element that priority queue can store */
	private int N;

	@SuppressWarnings("unchecked")
	public IndexedPriorityQueue(int deg, int maxSize) {

		D = Math.max(D, deg);
		N = Math.max(D + 1, maxSize);

		pm = new int[N];
		im = new int[N];
		values = new Object[N];
		parent = new int[N];
		child = new int[N];

		for (int i = 0; i < N; i++) {
			pm[i] = -1;
			im[i] = -1;

			parent[i] = (i - 1) / D;
			child[i] = D * i + 1;
		}
	}

	public int size() {
		return sz;
	}

	public boolean isEmpty() {
		return sz == 0;
	}

	public boolean contains(int ki) {
		return pm[ki] != -1;
	}

	/* first important method */
	public void insert(int ki, T value) {
		if (ki >= N || ki < 0)
			throw new IllegalArgumentException("Invalid ki!");

		pm[ki] = sz;
		im[sz] = ki;
		values[ki] = value;
		swim(sz++);
		System.out.println("size : "+sz);
		for(int i = 0; i < sz; i++) {
			System.out.println("["+im[i]+" - "+values[im[i]]+"] ");
		}
		
	}

	private void swim(int i) {
		while (less(i, parent[i])) {
			swap(parent[i], i);
			i = parent[i];
		}
	}

	private boolean less(int i, int j) {
		System.out.println("#### i : "+i + " #### j : "+j);
		return ((T) values[im[i]]).compareTo((T) values[im[j]]) < 0;
	}

	private void swap(int i, int j) {
		pm[im[i]] = j;
		pm[im[j]] = i;

		int temp = im[i];
		im[i] = im[j];
		im[j] = temp;
	}
	
	public T peek() {
		return (T) values[im[0]];
	}
	
	/* second important method */
	public T poll() {
		int ki_0 = im[0];
		int ki_sz = im[sz-1];
		
		pm[ki_sz] = 0;
		pm[ki_0] = -1;
		
		im[0] = ki_sz;
		im[--sz] = -1;
		
		T val = (T) values[ki_0];
		values[ki_0] = null;
		sink(0);
		return val;
	}
	
	private void sink(int i) {
		while(true) {
			if(i >= sz) return;
			
			int from = child[i];
			int to = Math.min(from + D - 1, sz-1);
			int smallest = from;
			if(smallest >= sz) return;
			for(int j = from; j <= to; j++) {
				if(((T) values[im[j]]).compareTo((T) values[im[smallest]]) < 0) {
					smallest = j;
				}
			}
			
			if(less(smallest, i)) {
				swap(i, smallest);
				i = smallest;
			} else {
				break;
			}
  		}
	}
	
	/* 3rd imp method */
	public T delete(int ki) {
		int pos = pm[ki];
		System.out.println("Pos : "+pos);
		//swap with last node
		pm[ki] = sz-1;
		pm[im[--sz]] = pos;
		
		im[pos]  = im[sz];
		im[sz] = ki;
		
		sink(pos);
		swim(pos);
		
		T val = (T) values[ki];
		values[ki] = null;
		
		return val;
	}
	
	/* 4rth imp method */
	public T update(int ki, T value) {
		if(ki <= sz || ki < 0) throw new IllegalArgumentException("Invalid key!!");
		final int i = pm[ki];
		T oldValue = (T) values[ki];
		sink(i);
		swim(i);
		return oldValue;
	}
	
	public void decreaseKey(int ki, T value) {
		if(ki <= sz || ki < 0) throw new IllegalArgumentException("Invalid key!!");
		values[ki] = value;
		swim(pm[ki]);
	}
	
	public void increaseKey(int ki, T value) {
		if(ki <= sz || ki < 0) throw new IllegalArgumentException("Invalid key!!");
		values[ki] = value;
		sink(pm[ki]);
	}
	
	public int peekKey() {
		return im[0];
	}

	public int[] getPm() {
		return pm;
	}

	public int[] getIm() {
		return im;
	}
	
	@SuppressWarnings("unchecked") 
	public Object[] getValues() { 
		return values;
	}
}
