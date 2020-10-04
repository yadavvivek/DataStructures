package com.vivek.practice;

public class UnionFindPra1 {

	int size;
	int[] id;
	int[] sz;
	int componentsSize;
	
	public UnionFindPra1(int size) {
		this.size = componentsSize = size;
		id = new int[size];
		sz = new int[size];
		
		for(int i = 0; i < size; i++) {
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	public boolean isConnected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		
		return rootP == rootQ;
	}
	
	public int find(int p) {
		int root = p;
		while(root != id[root])
			root = id[root];
		
		//path compression
		while(p != root) {
			int next = id[p];
			id[p] = root;
			p = next;
		}
		
		return root;
	}
	
	public int size() {
		return size;
	}
	
	public int componentSize() {
		return componentsSize;
	}
	
	public void unify(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		
		if(rootP == rootQ) return;
		
		if(sz[rootP] >= sz[rootQ]) {
			id[rootQ] = rootP;
			sz[rootP] += sz[rootQ];
		} else {
			id[rootP] = rootQ;
			sz[rootQ] += sz[rootP];
		}
		componentsSize--;
	}
	
	public int componentSizeOfGroup(int p) {
		return sz[find(p)];
	}
}
