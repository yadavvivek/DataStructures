package com.vivek.ds;

public class UnionFindDS {
	
	private int[] id;
	private int size;
	private int[] sz;
	private int mComponentsSize;
	
	public UnionFindDS(int size) {
		this.size = mComponentsSize = size;
	    for(int i = 0; i < size; i ++) {
	    	id[i] = i; 
	    	sz[i] = 1; 
	    }
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
	
	public boolean isConnected(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		
		return rootP == rootQ;
	}
	
	public int componentsSize() {
		return mComponentsSize;
	}
	
	public int size() {
		return size;
	}
	
	public int componentSizeOfGroup(int p) {
		return sz[find(p)];
	}
	
	public void unify(int p, int q) {
		int rootP = find(p);
		int rootQ = find(q);
		
		if(rootP == rootQ) return;
		
		if(sz[rootP] > sz[rootQ]) {
			id[rootQ] = rootP;
			sz[rootP] += sz[rootQ];
		} else {
			id[rootP] = rootQ;
			sz[rootQ] += sz[rootQ];
		}
		
		mComponentsSize --;
	}
}
